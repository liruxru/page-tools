package com.mt.tlstools.service;



import com.mt.tlstools.pojo.Carriage;
import com.mt.tlstools.pojo.StayLoadingTask;
import com.mt.tlstools.pojo.TaskVo;

import java.util.List;

public interface TaskService {
    List<StayLoadingTask> selectAll();

    /**
     * 查询正在装车的信息
     * @return
     */
    List<TaskVo> selectTaskLoadNow();

    /**
     * 查询车厢列表信息
     * @param loadLine
     * @param taskNum
     * @return
     */
    List<Carriage> queryCarriage(String loadLine, String taskNum);

    /**
     *
     */
    void updateNewDbFromOldDb();

}
