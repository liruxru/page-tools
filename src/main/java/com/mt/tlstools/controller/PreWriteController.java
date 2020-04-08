package com.mt.tlstools.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mt.tlstools.pojo.Point;
import com.mt.tlstools.pojo.ResponseMessage;
import com.mt.tlstools.pojo.SendPreCommandPo;
import com.mt.tlstools.pojo.SendPreCommandPoList;
import com.mt.tlstools.service.PreWriteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 向pre 中写入
 */
@RestController
@Slf4j
@CrossOrigin
public class PreWriteController {
    @Autowired
    private PreWriteService preWriteService;
    @Value("${spring.profiles.active}")
    private String activeProfile;

    @RequestMapping("writePoint")
    public ResponseMessage writePoint(SendPreCommandPo sendPreCommandPo) throws JsonProcessingException {
        //log.info(""+sendPreCommandPo);
        if ("dev".equals(activeProfile)) {
            preWriteService.writePoint(sendPreCommandPo);
            return ResponseMessage.ok();
        }
        return ResponseMessage.fail(-1,"不支持在生产环境测试");
    }

    @RequestMapping("writePoints")
    public ResponseMessage writePoints(SendPreCommandPoList sendPreCommandPoList) throws JsonProcessingException {
        if ("dev".equals(activeProfile)) {
            for (int i = sendPreCommandPoList.getPointId().intValue(); i <= sendPreCommandPoList.getPointIdEnd().intValue(); i++) {
                preWriteService.writePoint(new SendPreCommandPo(i, sendPreCommandPoList.getRawValue(), null));
            }
            return ResponseMessage.ok();
        }
        return ResponseMessage.fail(-1,"不支持在生产环境测试");
    }
    @RequestMapping("writePointList")
    public ResponseMessage writePointList(SendPreCommandPoList sendPreCommandPoList) throws JsonProcessingException {
        if ("dev".equals(activeProfile)) {
            List<SendPreCommandPo> commandPos = new ArrayList<>();
            for (int i = sendPreCommandPoList.getPointId().intValue(); i <= sendPreCommandPoList.getPointIdEnd().intValue(); i++) {
                commandPos.add(new SendPreCommandPo(i, sendPreCommandPoList.getRawValue(), null));
            }
            preWriteService.writePointList(commandPos);
            return ResponseMessage.ok();
        }
        return ResponseMessage.fail(-1,"不支持在生产环境测试");
    }
    @RequestMapping("writeSinglePoint")
    public ResponseMessage writeSinglePoint(@RequestBody Point point){
        try {
            preWriteService.writeSinglePoint(point);
            return  ResponseMessage.ok();
        }catch (Exception e){
            return  ResponseMessage.fail(-1,e.getMessage());
        }

    }
}
