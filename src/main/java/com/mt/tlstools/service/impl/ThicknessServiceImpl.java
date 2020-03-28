package com.mt.tlstools.service.impl;

import com.mt.tlstools.config.ConstantConfig;
import com.mt.tlstools.document.BiasedLoad;
import com.mt.tlstools.document.BiasedLoadDao;
import com.mt.tlstools.pojo.UnbalanceResult;
import com.mt.tlstools.repository.MongoDao;
import com.mt.tlstools.service.ThicknessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class ThicknessServiceImpl implements ThicknessService {
    @Autowired
    private MongoDao mongoDao;

    @Override
    public List<UnbalanceResult> getRadarData(String loadLine, String taskNum, String trainNum) {
        BiasedLoadDao biasedLoad = new BiasedLoadDao();
        biasedLoad.setTaskNum(taskNum);
        biasedLoad.setTrainNum(trainNum);
        BiasedLoadDao biasedLoadDo = null;
        List<UnbalanceResult> unbalanceResults = new ArrayList<>();
        if (ConstantConfig.LOAD_LINE_01.equals(loadLine)) {
            biasedLoadDo = mongoDao.findBiasedLoad(biasedLoad);
        } else {
            biasedLoadDo = mongoDao.findBiasedLoad2(biasedLoad);
        }

        if (biasedLoadDo != null) {
            List<BiasedLoad> biasedLoadList = biasedLoadDo.getBiasedLoadList();

            biasedLoadList.sort(Comparator.comparingInt(BiasedLoad::getPoint));
            for (BiasedLoad load : biasedLoadList) {
                UnbalanceResult unbalanceResult = new UnbalanceResult();
                unbalanceResult.setPosition(load.getPoint() + "");
                unbalanceResult.setUnbalanceValue(load.getValue() + "");
                unbalanceResults.add(unbalanceResult);
            }
        }
        return unbalanceResults;
    }
}
