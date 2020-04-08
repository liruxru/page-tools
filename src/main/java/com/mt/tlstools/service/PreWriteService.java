package com.mt.tlstools.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mt.tlstools.pojo.Point;
import com.mt.tlstools.pojo.SendPreCommandPo;

import java.util.List;

public interface PreWriteService {
    void writePoint(SendPreCommandPo sendPreCommandPo) throws JsonProcessingException;

    void writePointList(List<SendPreCommandPo> commandPos) throws JsonProcessingException;

    void writeSinglePoint(Point point) throws Exception;
}
