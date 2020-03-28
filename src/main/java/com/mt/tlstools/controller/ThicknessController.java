package com.mt.tlstools.controller;

import com.mt.tlstools.config.ConstantConfig;
import com.mt.tlstools.corecache.CacheLoadLine;
import com.mt.tlstools.corecache.CacheLoadLine1;
import com.mt.tlstools.corecache.CacheLoadLine2;
import com.mt.tlstools.pojo.UnbalanceResult;
import com.mt.tlstools.service.ThicknessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@CrossOrigin
public class ThicknessController {
    @Autowired
    private CacheLoadLine1 cacheLoadLine1;
    @Autowired
    private CacheLoadLine2 cacheLoadLine2;
    @Autowired
    private ThicknessService thicknessService;

    @RequestMapping("realTimeRadarData")
    @ResponseBody
    public Map<String,Object> getThicknessData(String loadLine) {
        Map<Integer, Number> actualDataValue = new HashMap<>();

        if(ConstantConfig.LOAD_LINE_01.equals(loadLine)){
            actualDataValue = cacheLoadLine1.getActualDataValue();
        }else if(ConstantConfig.LOAD_LINE_02.equals(loadLine)){
            actualDataValue = cacheLoadLine2.getActualDataValue();
        }

        // 西克测厚数据的id 范围为 581-1121
        int[] sicknessData = new int[541];
        for (int i = 0; i < sicknessData.length; i++) {
            //log.info("雷达数据{}",actualDataValue.get(i+581));
            if(null!=actualDataValue.get(i+581)){
                sicknessData[i] = actualDataValue.get(i+581).intValue();
            }else{
                sicknessData[i] = i;
                log.error(i+581+"无数据");
            }


        }
        // id 范围为 581-1121  总共541个点
        int[] keys = new int[sicknessData.length];
        for(int i=0;i<sicknessData.length;i++){
            keys[i]=i;
        }
        Map map = new HashMap();
        map.put("keys",keys);
        map.put("value",sicknessData);
        return map;
    }
    @RequestMapping("getRadarDataGraph")
    public List<UnbalanceResult> getRadarData(String loadLine, String taskNum, String trainNum){
        return thicknessService.getRadarData(loadLine,taskNum,trainNum);
    }
}
