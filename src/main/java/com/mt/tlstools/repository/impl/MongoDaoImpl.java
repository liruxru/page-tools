package com.mt.tlstools.repository.impl;

import com.mt.tlstools.document.ActualDataOfPre;
import com.mt.tlstools.document.BiasedLoadDao;
import com.mt.tlstools.document.ThicknessInfoOld;
import com.mt.tlstools.repository.MongoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 *项目名: tls
 *文件名: MongoDaoImpl
 *创建者: mt-liuy liuyang@tjmeiteng.com
 *创建时间:2019/4/17 12:13
 *描述: TODO
 */
@Repository
public class MongoDaoImpl implements MongoDao {

    @Autowired
    @Qualifier("userDb1MongoTemplate")
    private MongoTemplate mongoTemplate;
    @Autowired
    @Qualifier("userDb2MongoTemplate")
    private MongoTemplate userDb2MongoTemplate;

    /**
     * 取得偏载历史记录
     * @param biasedLoad
     * @return
     */
    @Override
    public BiasedLoadDao findBiasedLoad(BiasedLoadDao biasedLoad) {
        Criteria criatira = new Criteria();
        criatira.andOperator(Criteria.where("taskNum").is(biasedLoad.getTaskNum()),
                Criteria.where("trainNum").is(biasedLoad.getTrainNum()));
        BiasedLoadDao biasedLoadDao = mongoTemplate.findOne(new Query(criatira), BiasedLoadDao.class);
        return biasedLoadDao;
    }

    @Override
    public BiasedLoadDao findBiasedLoad2(BiasedLoadDao biasedLoadDao) {
        Criteria criteria = new Criteria();
        criteria.andOperator(Criteria.where("taskNum").is(biasedLoadDao.getTaskNum()),
                Criteria.where("trainNum").is(biasedLoadDao.getTrainNum()));
        BiasedLoadDao biasedLoad = userDb2MongoTemplate.findOne(new Query(criteria), BiasedLoadDao.class);
        return biasedLoad;
    }

    @Override
    public List<ActualDataOfPre> findLoadLine1RealTimeData() {
        return mongoTemplate.findAll(ActualDataOfPre.class);
    }
    @Override
    public List<ActualDataOfPre> findLoadLine2RealTimeData() {
        return userDb2MongoTemplate.findAll(ActualDataOfPre.class);
    }

    /**
     * 查询旧版的装车雷达数据
     * @param thicknessInfoOld
     * @return
     */
    @Override
    public ThicknessInfoOld findOldThickness(ThicknessInfoOld thicknessInfoOld) {
        Criteria criteria = new Criteria();
        criteria.andOperator(Criteria.where("taskNum").is(thicknessInfoOld.getTaskNum()),
                Criteria.where("trainNum").is(thicknessInfoOld.getTrainNum()));
        ThicknessInfoOld one = mongoTemplate.findOne(new Query(criteria), ThicknessInfoOld.class);
        return one;
    }

    @Override
    public void insertNewDbThickness(BiasedLoadDao biasedLoadDao) {
        userDb2MongoTemplate.insert(biasedLoadDao);
    }

}
