package com.mt.tlstools.corecache;

import com.mt.tlstools.document.ActualDataOfPre;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CacheLoadLine {
    // 实时数据(pre的点,包括虚拟点)
    protected final ConcurrentHashMap<Integer, Number> pointValueMap = new ConcurrentHashMap<>(1200);

    /**
     * 系统启动时 加载所有实时数据
     *
     * @param realTimePointData
     */
    public void putRealTimePointDataAllFirstTime(Map<Integer, Number> realTimePointData) {
        pointValueMap.putAll(realTimePointData);
    }

    /**
     * 批量更新实时数据
     *
     * @param dataMap
     */
    public void updateActualData(Map<Integer, Number> dataMap) {
        pointValueMap.putAll(dataMap);
    }

    /**
     * 单点更新实时数据
     *
     * @param pointId 点ID
     * @param value   数据值
     */
    public void updateActualData(Integer pointId, Number value) {
        pointValueMap.put(pointId, value);
    }

    /**
     * 获取全部实时数据
     *
     * @return
     */
    public Map<Integer, Number> getActualDataValue() {
        return pointValueMap;
    }

    public Number getValueById(Integer pointId) {
        return pointValueMap.get(pointId);
    }

    public void putRealTimePointDataAllFirstTime(List<ActualDataOfPre> loadLine1RealTimeData) {
        for (ActualDataOfPre actualDataOfPre : loadLine1RealTimeData) {
            pointValueMap.put(actualDataOfPre.getPointId(), actualDataOfPre.getDataValue());
        }
    }
}
