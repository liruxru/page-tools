package com.mt.tlstools.mapper.dst;

import com.mt.tlstools.pojo.Carriage;
import com.mt.tlstools.pojo.CarriageDetail;
import com.mt.tlstools.pojo.StayLoadingTask;
import com.mt.tlstools.pojo.TaskVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DstStayLoadingTaskMapper {
    List<StayLoadingTask> selectAll();

    List<TaskVo> selectTaskLoadNow();

    List<Carriage> selectCarriageByTaskNum(String taskNum);

    void updateNewDbTask(TaskVo taskVo);

    /**
     * 更新数据库车厢信息
     * @param carriageDetail
     */
    void updateNewDbCarriage(CarriageDetail carriageDetail);
}
