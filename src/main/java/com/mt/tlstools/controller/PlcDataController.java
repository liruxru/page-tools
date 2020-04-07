package com.mt.tlstools.controller;

import com.mt.tlstools.pojo.Device;
import com.mt.tlstools.pojo.ImportantData;
import com.mt.tlstools.service.PlcDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class PlcDataController {
    @Autowired
    private PlcDataService plcDataService;
    @RequestMapping("/refreshImportantData")
    public ImportantData refreshImportantData(@RequestParam String loadLine){
        return  plcDataService.refreshImportantData(loadLine);
    }
    @RequestMapping("/devices")
    public List<Device> devices(){
        return  plcDataService.devices();
    }
}
