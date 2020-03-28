package com.mt.tlstools.controller;

import com.mt.tlstools.pojo.Carriage;
import com.mt.tlstools.pojo.ResponseMessage;
import com.mt.tlstools.pojo.TaskVo;
import com.mt.tlstools.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TaskController {
    @Autowired
    private TaskService taskService;
    @RequestMapping("/taskList")
    @CrossOrigin()
    public List<TaskVo> taskListLoadNow(){
        return  taskService.selectTaskLoadNow();
    }
    @RequestMapping(value="/queryCarriage",method = RequestMethod.POST)
    public List<Carriage> queryCarriage(@RequestParam String loadLine, @RequestParam String taskNum){
        return  taskService.queryCarriage(loadLine,taskNum);
    }
    @RequestMapping("/syncTask")
    public ResponseMessage<String> syncTask(){
        return ResponseMessage.fail(-1,"同步工作之前做完了，修改源码做其他工作");
//        System.out.println("执行任务同步");
//        taskService.updateNewDbFromOldDb();
//        System.out.println("执行任务同步over");
//        return ResponseMessage.ok();
    }
}
