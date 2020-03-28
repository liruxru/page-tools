package com.mt.tlstools.onstart;

import com.mt.tlstools.corecache.CacheLoadLine1;
import com.mt.tlstools.corecache.CacheLoadLine2;
import com.mt.tlstools.document.ActualDataOfPre;
import com.mt.tlstools.repository.MongoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 启动时加载实时数据到内存
 */
@Component
public class OnStartUp   implements ApplicationRunner {
    @Autowired
    private MongoDao mongoDao;
    @Autowired
    private CacheLoadLine1 cacheLoadLine1;
    @Autowired
    private CacheLoadLine2 cacheLoadLine2;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 更新内部缓存
        List<ActualDataOfPre> loadLine1RealTimeData = mongoDao.findLoadLine1RealTimeData();
        cacheLoadLine1.putRealTimePointDataAllFirstTime(loadLine1RealTimeData);
        List<ActualDataOfPre> loadLine2RealTimeData = mongoDao.findLoadLine2RealTimeData();
        cacheLoadLine2.putRealTimePointDataAllFirstTime(loadLine2RealTimeData);

    }

}
