package com.mt.tlstools.repository;

/*
 *项目名: tls
 *文件名: MongoDao
 *创建者: mt-liuy liuyang@tjmeiteng.com
 *创建时间:2019/4/17 12:12
 *描述: TODO
 */


import com.mt.tlstools.document.ActualDataOfPre;
import com.mt.tlstools.document.BiasedLoadDao;
import com.mt.tlstools.document.ThicknessInfoOld;

import java.util.List;

public interface MongoDao {

    /**
     * 取得偏载历史记录
     * @param biasedLoad
     * @return
     */
    BiasedLoadDao findBiasedLoad(BiasedLoadDao biasedLoad);

    BiasedLoadDao findBiasedLoad2(BiasedLoadDao biasedLoadDao);

    List<ActualDataOfPre> findLoadLine1RealTimeData();

    List<ActualDataOfPre> findLoadLine2RealTimeData();

    ThicknessInfoOld findOldThickness(ThicknessInfoOld thicknessInfoOld);

    void insertNewDbThickness(BiasedLoadDao biasedLoadDao);
}
