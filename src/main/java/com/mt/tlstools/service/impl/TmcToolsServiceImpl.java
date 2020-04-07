package com.mt.tlstools.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mt.tlstools.config.ConstantConfig;
import com.mt.tlstools.config.RedisChannelConstants;
import com.mt.tlstools.corecache.CacheLoadLine1;
import com.mt.tlstools.corecache.CacheLoadLine2;
import com.mt.tlstools.mapper.src.CoalFeederMapper;
import com.mt.tlstools.pojo.CoalFeeder;
import com.mt.tlstools.pojo.SendPreCommandPo;
import com.mt.tlstools.service.TmcToolsService;
import com.mt.tlstools.util.JacksonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TmcToolsServiceImpl implements TmcToolsService {
    @Autowired
    private CoalFeederMapper coalFeederMapper;
    @Autowired
    private CacheLoadLine1 cacheLoadLine1;
    @Autowired
    private CacheLoadLine2 cacheLoadLine2;
    @Autowired
    @Qualifier("redisTemplateLoadLine1")
    private RedisTemplate<String, String> redisTemplateLoadLine1;
    @Autowired
    @Qualifier("redisTemplateLoadLine2")
    private RedisTemplate<String, String> redisTemplateLoadLine2;

    @Override
    public List<CoalFeeder> getCoalFeeders(String loadLine) {
        List<CoalFeeder> coalFeeders = coalFeederMapper.selectCoalByLoadLine(loadLine);
        for (CoalFeeder coalFeeder : coalFeeders) {
            if (ConstantConfig.LOAD_LINE_01.equals(loadLine)) {
                coalFeeder.setInputRunHz(cacheLoadLine1.getValueById(coalFeeder.getInputHzId()).floatValue());
                coalFeeder.setOutputRunHz(cacheLoadLine1.getValueById(coalFeeder.getOutputHzId()).floatValue());
                coalFeeder.setRunStatus(cacheLoadLine1.getValueById(coalFeeder.getRunStatusId()).intValue() == 1 ? true : false);
            } else {
                coalFeeder.setInputRunHz(cacheLoadLine2.getValueById(coalFeeder.getInputHzId()).floatValue());
                coalFeeder.setOutputRunHz(cacheLoadLine2.getValueById(coalFeeder.getOutputHzId()).floatValue());
                coalFeeder.setRunStatus(cacheLoadLine2.getValueById(coalFeeder.getRunStatusId()).intValue() == 1 ? true : false);
            }
        }


        return coalFeeders;
    }

    @Override
    public void startCoalFeeder(CoalFeeder coalFeeder) throws JsonProcessingException {
        Integer runId = coalFeeder.getRunId();
        Integer stopId = coalFeeder.getStopId();
        List<SendPreCommandPo> commandPos = new ArrayList<>();
        SendPreCommandPo sendPreCommandPo = new SendPreCommandPo();
        sendPreCommandPo.setPointId(runId);
        sendPreCommandPo.setRawValue(1);
        commandPos.add(sendPreCommandPo);
        SendPreCommandPo sendPreCommandPo2 = new SendPreCommandPo();
        sendPreCommandPo2.setPointId(stopId);
        sendPreCommandPo2.setRawValue(0);
        commandPos.add(sendPreCommandPo2);
        if (ConstantConfig.LOAD_LINE_01.equals(coalFeeder.getLoadLine())) {
            redisTemplateLoadLine1.convertAndSend(RedisChannelConstants.PRE_COMMAND_CHANNEL, JacksonUtil.obj2json(commandPos));
        } else if (ConstantConfig.LOAD_LINE_02.equals(coalFeeder.getLoadLine())) {
            redisTemplateLoadLine2.convertAndSend(RedisChannelConstants.PRE_COMMAND_CHANNEL, JacksonUtil.obj2json(commandPos));
        }


    }

    @Override
    public void stopCoalFeeder(CoalFeeder coalFeeder) throws JsonProcessingException {
        Integer runId = coalFeeder.getRunId();
        Integer stopId = coalFeeder.getStopId();
        List<SendPreCommandPo> commandPos = new ArrayList<>();
        SendPreCommandPo sendPreCommandPo = new SendPreCommandPo();
        sendPreCommandPo.setPointId(runId);
        sendPreCommandPo.setRawValue(0);
        commandPos.add(sendPreCommandPo);
        SendPreCommandPo sendPreCommandPo2 = new SendPreCommandPo();
        sendPreCommandPo2.setPointId(stopId);
        sendPreCommandPo2.setRawValue(1);
        commandPos.add(sendPreCommandPo2);
        if (ConstantConfig.LOAD_LINE_01.equals(coalFeeder.getLoadLine())) {
            redisTemplateLoadLine1.convertAndSend(RedisChannelConstants.PRE_COMMAND_CHANNEL, JacksonUtil.obj2json(commandPos));
        } else if (ConstantConfig.LOAD_LINE_02.equals(coalFeeder.getLoadLine())) {
            redisTemplateLoadLine2.convertAndSend(RedisChannelConstants.PRE_COMMAND_CHANNEL, JacksonUtil.obj2json(commandPos));
        }
    }

    @Override
    public void resetCoalFeeder(CoalFeeder coalFeeder) throws JsonProcessingException {
        Integer runId = coalFeeder.getRunId();
        Integer stopId = coalFeeder.getStopId();

        List<SendPreCommandPo> commandPos = new ArrayList<>();
        SendPreCommandPo sendPreCommandPo = new SendPreCommandPo();
        sendPreCommandPo.setPointId(runId);
        sendPreCommandPo.setRawValue(0);
        commandPos.add(sendPreCommandPo);
        SendPreCommandPo sendPreCommandPo2 = new SendPreCommandPo();
        sendPreCommandPo2.setPointId(stopId);
        sendPreCommandPo2.setRawValue(0);
        commandPos.add(sendPreCommandPo2);
        if (ConstantConfig.LOAD_LINE_01.equals(coalFeeder.getLoadLine())) {
            redisTemplateLoadLine1.convertAndSend(RedisChannelConstants.PRE_COMMAND_CHANNEL, JacksonUtil.obj2json(commandPos));
        } else if (ConstantConfig.LOAD_LINE_02.equals(coalFeeder.getLoadLine())) {
            redisTemplateLoadLine2.convertAndSend(RedisChannelConstants.PRE_COMMAND_CHANNEL, JacksonUtil.obj2json(commandPos));
        }
    }

    @Override
    public void updateFeederRunHz(CoalFeeder coalFeeder) throws JsonProcessingException {
        Float inputRunHz = coalFeeder.getInputRunHz();
        Integer inputHzId = coalFeeder.getInputHzId();
        List<SendPreCommandPo> commandPos = new ArrayList<>();
        SendPreCommandPo sendPreCommandPo = new SendPreCommandPo();
        sendPreCommandPo.setPointId(inputHzId);
        sendPreCommandPo.setRawValue(inputRunHz);
        commandPos.add(sendPreCommandPo);
        if (ConstantConfig.LOAD_LINE_01.equals(coalFeeder.getLoadLine())) {
            redisTemplateLoadLine1.convertAndSend(RedisChannelConstants.PRE_COMMAND_CHANNEL, JacksonUtil.obj2json(commandPos));
        } else if (ConstantConfig.LOAD_LINE_02.equals(coalFeeder.getLoadLine())) {
            redisTemplateLoadLine2.convertAndSend(RedisChannelConstants.PRE_COMMAND_CHANNEL, JacksonUtil.obj2json(commandPos));
        }
    }
}
