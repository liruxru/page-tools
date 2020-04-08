package com.mt.tlstools.service;

import com.mt.tlstools.pojo.Device;
import com.mt.tlstools.pojo.ImportantData;
import com.mt.tlstools.pojo.Point;

import java.util.List;
import java.util.Map;

public interface PlcDataService {
    ImportantData refreshImportantData(String loadLine);

    List<Device> devices();

    Map<String, List<Point>> points(int[] deviceIds, String loadLine);

}
