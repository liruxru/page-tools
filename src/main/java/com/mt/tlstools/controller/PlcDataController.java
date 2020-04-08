package com.mt.tlstools.controller;

import com.mt.tlstools.pojo.Device;
import com.mt.tlstools.pojo.ImportantData;
import com.mt.tlstools.pojo.Point;
import com.mt.tlstools.service.PlcDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    @RequestMapping("/points")
    public Map<String, List<Point>> points(@RequestBody int[] deviceIds, @RequestParam String loadLine){
        return  plcDataService.points(deviceIds,loadLine);
    }
}
