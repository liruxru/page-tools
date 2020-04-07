package com.mt.tlstools.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mt.tlstools.pojo.CoalFeeder;
import com.mt.tlstools.pojo.ResponseMessage;
import com.mt.tlstools.service.TmcToolsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class TmcToolsController {
    @Autowired
    private TmcToolsService tmcToolsService;
    @RequestMapping("getCoalFeeders")
    public List<CoalFeeder> getCoalFeeders(String loadLine){
        return  tmcToolsService.getCoalFeeders(loadLine);
    }
    @RequestMapping("startCoalFeeder")
    public ResponseMessage<String> startCoalFeeder(CoalFeeder coalFeeder) throws JsonProcessingException {
        tmcToolsService.startCoalFeeder(coalFeeder);
        return ResponseMessage.ok();
    }
    @RequestMapping("stopCoalFeeder")
    public ResponseMessage<String> stopCoalFeeder(CoalFeeder coalFeeder) throws JsonProcessingException {
        tmcToolsService.stopCoalFeeder(coalFeeder);
        return ResponseMessage.ok();
    }
    @RequestMapping("resetCoalFeeder")
    public ResponseMessage<String> resetCoalFeeder(CoalFeeder coalFeeder) throws JsonProcessingException {
        tmcToolsService.resetCoalFeeder(coalFeeder);
        return ResponseMessage.ok();
    }
    @RequestMapping("updateFeederRunHz")
    public ResponseMessage<String> updateFeederRunHz(CoalFeeder coalFeeder) throws JsonProcessingException {
        tmcToolsService.updateFeederRunHz(coalFeeder);
        return ResponseMessage.ok();
    }
}
