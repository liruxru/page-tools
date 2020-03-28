package com.mt.tlstools.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mt.tlstools.config.RedisChannelConstants;
import com.mt.tlstools.pojo.SendPreCommandPo;
import com.mt.tlstools.service.PreWriteService;
import com.mt.tlstools.util.JacksonUtil;
import com.mt.tlstools.util.MyStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PreWriteServiceImpl implements PreWriteService {
    @Autowired@Qualifier("redisTemplateLoadLine1")
    private RedisTemplate<String,String> redisTemplateLoadLine1;
    @Override
    public void writePoint(SendPreCommandPo sendPreCommandPo) throws JsonProcessingException {
        List<SendPreCommandPo> pos = new ArrayList<>();
        sendPreCommandPo.setRawValue(MyStringUtils.parseString2Number(sendPreCommandPo.getRawValue().toString()));
        pos.add(sendPreCommandPo);
        redisTemplateLoadLine1.convertAndSend(RedisChannelConstants.PRE_COMMAND_CHANNEL, JacksonUtil.obj2json(pos));
    }

    @Override
    public void writePointList(List<SendPreCommandPo> commandPos) throws JsonProcessingException {
        redisTemplateLoadLine1.convertAndSend(RedisChannelConstants.PRE_COMMAND_CHANNEL, JacksonUtil.obj2json(commandPos));
    }


}
