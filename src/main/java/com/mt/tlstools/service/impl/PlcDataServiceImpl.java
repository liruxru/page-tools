package com.mt.tlstools.service.impl;

import com.mt.tlstools.config.ConstantConfig;
import com.mt.tlstools.corecache.CacheLoadLine1;
import com.mt.tlstools.corecache.CacheLoadLine2;
import com.mt.tlstools.mapper.src.DeviceMapper;
import com.mt.tlstools.pojo.Device;
import com.mt.tlstools.pojo.ImportantData;
import com.mt.tlstools.service.PlcDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
