package com.mt.tlstools.service.impl;

import com.mt.tlstools.config.ConstantConfig;
import com.mt.tlstools.corecache.CacheLoadLine1;
import com.mt.tlstools.corecache.CacheLoadLine2;
import com.mt.tlstools.mapper.src.DeviceMapper;
import com.mt.tlstools.pojo.Device;
import com.mt.tlstools.pojo.ImportantData;
import com.mt.tlstools.pojo.Point;
import com.mt.tlstools.service.PlcDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PlcDataServiceImpl implements PlcDataService {
    @Autowired
    private CacheLoadLine1 cacheLoadLine1;
    @Autowired
    private CacheLoadLine2 cacheLoadLine2;
    @Autowired
    private DeviceMapper deviceMapper;
    @Override
    public ImportantData refreshImportantData(String loadLine) {
        ImportantData importantData = new ImportantData();
        if (ConstantConfig.LOAD_LINE_01.equals(loadLine)) {
            Number softAuto = cacheLoadLine1.getValueById(ConstantConfig.SOFT_AUTO);
            importantData.setSoftAuto(softAuto==null?null:softAuto.intValue()==1?true:false);
            Number weight = cacheLoadLine1.getValueById(ConstantConfig.WEIGHT);
            importantData.setWeight(weight==null?null:weight.doubleValue());
            Number length1 = cacheLoadLine1.getValueById(ConstantConfig.LENGTH1);
            importantData.setLength1(length1==null?null:length1.doubleValue());
            Number length2 = cacheLoadLine1.getValueById(ConstantConfig.LENGTH2);
            importantData.setLength2(length2==null?null:length2.doubleValue());
        } else {
            Number softAuto = cacheLoadLine2.getValueById(ConstantConfig.SOFT_AUTO);
            importantData.setSoftAuto(softAuto==null?null:softAuto.intValue()==1?true:false);
            Number weight = cacheLoadLine2.getValueById(ConstantConfig.WEIGHT);
            importantData.setWeight(weight==null?null:weight.doubleValue());
            Number length1 = cacheLoadLine2.getValueById(ConstantConfig.LENGTH1);
            importantData.setLength1(length1==null?null:length1.doubleValue());
            Number length2 = cacheLoadLine2.getValueById(ConstantConfig.LENGTH2);
            importantData.setLength2(length2==null?null:length2.doubleValue());
        }
        return importantData;
    }

    @Override
    public List<Device> devices() {
        return deviceMapper.selectDevices();

    }


    @Override
    public Map<String, List<Point>> points(int[] deviceIds, String loadLine) {
        Map<String,List<Point>> data = new HashMap<>();
        List<Point> roPoints = deviceMapper.selectOnlyReadPoints(deviceIds);
        if(ConstantConfig.LOAD_LINE_01.equals(loadLine)){
            for (Point point : roPoints) {
              point.setPointValue(cacheLoadLine1.getValueById(point.getPointId()));
              point.setLoadLine(ConstantConfig.LOAD_LINE_01);
            }
        }else if(ConstantConfig.LOAD_LINE_02.equals(loadLine)){
            for (Point point : roPoints) {
                point.setPointValue(cacheLoadLine2.getValueById(point.getPointId()));
                point.setLoadLine(ConstantConfig.LOAD_LINE_02);
            }
        }
        data.put("or",roPoints);
        List<Point> wrPoints = deviceMapper.selectReadWritePoints(deviceIds);
        if(ConstantConfig.LOAD_LINE_01.equals(loadLine)){
            for (Point point : wrPoints) {
                point.setPointValue(cacheLoadLine1.getValueById(point.getPointId()));
                point.setLoadLine(ConstantConfig.LOAD_LINE_01);
            }
        }else if(ConstantConfig.LOAD_LINE_02.equals(loadLine)){
            for (Point point : wrPoints) {
                point.setPointValue(cacheLoadLine2.getValueById(point.getPointId()));
                point.setLoadLine(ConstantConfig.LOAD_LINE_02);
            }
        }
        data.put("wr",wrPoints);
        return data;
    }
}
