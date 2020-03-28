package com.mt.tlstools.mapper.src;

import com.mt.tlstools.pojo.Carriage;
import com.mt.tlstools.pojo.CarriageDetail;
import com.mt.tlstools.pojo.StayLoadingTask;
import com.mt.tlstools.pojo.TaskVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SrcStayLoadingTaskMapper {
    List<StayLoadingTask> selectAll();

    List<TaskVo> selectTaskLoadNow();

    List<Carriage> selectCarriageByTaskNum(String taskNum);

    List<TaskVo> selectOldDbTask();

    List<CarriageDetail> selectCarriageDetailByTaskNum(String taskNum);
}
