package com.mt.tlstools.service;

import com.mt.tlstools.pojo.UnbalanceResult;

import java.util.List;

public interface ThicknessService {
    List<UnbalanceResult> getRadarData(String loadLine, String taskNum, String trainNum);

}
