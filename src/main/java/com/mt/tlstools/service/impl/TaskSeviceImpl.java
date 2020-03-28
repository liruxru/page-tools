package com.mt.tlstools.service.impl;

import com.mt.tlstools.config.ConstantConfig;
import com.mt.tlstools.document.BiasedLoad;
import com.mt.tlstools.document.BiasedLoadDao;
import com.mt.tlstools.document.ThicknessInfoOld;
import com.mt.tlstools.mapper.dst.DstStayLoadingTaskMapper;
import com.mt.tlstools.mapper.src.SrcStayLoadingTaskMapper;
import com.mt.tlstools.pojo.Carriage;
import com.mt.tlstools.pojo.CarriageDetail;
import com.mt.tlstools.pojo.StayLoadingTask;
import com.mt.tlstools.pojo.TaskVo;
import com.mt.tlstools.repository.MongoDao;
import com.mt.tlstools.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TaskSeviceImpl implements TaskService {
    @Autowired
    private SrcStayLoadingTaskMapper srcStayLoadingTaskMapper;
    @Autowired
    private DstStayLoadingTaskMapper dstStayLoadingTaskMapper;
    @Autowired
    private MongoDao mongoDao;

    @Override
    public List<StayLoadingTask> selectAll() {
        return srcStayLoadingTaskMapper.selectAll();
    }

    @Override
    public List<TaskVo> selectTaskLoadNow() {
        List<TaskVo> tsks = new ArrayList<>();
        List<TaskVo> taskVo1 = srcStayLoadingTaskMapper.selectTaskLoadNow();
        List<TaskVo> taskVo2 = dstStayLoadingTaskMapper.selectTaskLoadNow();
        tsks.addAll(taskVo1);
        tsks.addAll(taskVo2);
        return tsks;
    }

    @Override
    public List<Carriage> queryCarriage(String loadLine, String taskNum) {
        List<Carriage> carriages = null;
        if (ConstantConfig.LOAD_LINE_01.equals(loadLine)) {
            carriages = srcStayLoadingTaskMapper.selectCarriageByTaskNum(taskNum);
        } else {
            carriages = dstStayLoadingTaskMapper.selectCarriageByTaskNum(taskNum);
        }
        if (carriages != null) {
            for (Carriage carriage : carriages) {
                carriage.setLoadLine(loadLine);
            }
        }
        return carriages;
    }

    @Override
    public void updateNewDbFromOldDb() {
        // 从旧数据查询数据 查询已经完成的  任务状态为 4 装车模式是自动的 mqdelete = 0  loadLine = 400013 的
        List<TaskVo> taskVos =  srcStayLoadingTaskMapper.selectOldDbTask();

        // 遍历任务   更新mysql  stay_loading_task  carriage 表 字段  插入mongo雷达数据
        for (TaskVo taskVo : taskVos) {
            dstStayLoadingTaskMapper.updateNewDbTask(taskVo);

            List<CarriageDetail> carriageDetails = srcStayLoadingTaskMapper.selectCarriageDetailByTaskNum(taskVo.getTaskNum());
            for (CarriageDetail carriageDetail : carriageDetails) {
                // 更新车厢列表信息
                dstStayLoadingTaskMapper.updateNewDbCarriage(carriageDetail);
                // 插入mongo雷达信息
                String taskNum = taskVo.getTaskNum();
                String trainNum = carriageDetail.getTrainNum();
                int orderNum = carriageDetail.getOrderNum();
//                updatemongoThick(taskNum, trainNum, orderNum);



            }


        }
        // stayloadingtask 包括

    }

    private void updatemongoThick(String taskNum, String trainNum, int orderNum) {
        ThicknessInfoOld thicknessInfoOld = new ThicknessInfoOld();
        thicknessInfoOld.setTaskNum(taskNum);
        thicknessInfoOld.setTrainNum(trainNum);
        thicknessInfoOld = mongoDao.findOldThickness(thicknessInfoOld);

        if(thicknessInfoOld!=null){
            // 转换   插入新库
            List<BiasedLoad> biasedLoadList = new ArrayList<>();
            Map<Integer, Double> result = thicknessInfoOld.getResult();

            Set<Integer> integers = result.keySet();
            for (Integer integer : integers) {
                BiasedLoad biasedLoad = new BiasedLoad();
                biasedLoad.setPoint(integer);
                biasedLoad.setValue((float)(result.get(integer)*1.0));
                biasedLoadList.add(biasedLoad);
            }

            BiasedLoadDao biasedLoadDao = new BiasedLoadDao();
            biasedLoadDao.setTrainNum(trainNum);
            biasedLoadDao.setTaskNum(taskNum);
            biasedLoadDao.setOrderNum(orderNum);
            biasedLoadDao.setBiasedLoadList(biasedLoadList);
            biasedLoadDao.setCreateTime(new Date());
            mongoDao.insertNewDbThickness(biasedLoadDao);
        }
    }
}
