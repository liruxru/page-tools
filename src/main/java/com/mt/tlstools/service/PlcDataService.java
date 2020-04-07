package com.mt.tlstools.service;

import com.mt.tlstools.pojo.Device;
import com.mt.tlstools.pojo.ImportantData;

import java.util.List;

public interface PlcDataService {
    ImportantData refreshImportantData(String loadLine);

    List<Device> devices();

}
