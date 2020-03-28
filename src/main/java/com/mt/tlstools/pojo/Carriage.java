package com.mt.tlstools.pojo;

import lombok.Data;

@Data
public class Carriage {
    private String taskNum;  // 任务号码
    private int orderNum;    // 顺序序号
    private String trainNum;  // 车厢号码
    private String loadLine;  // 装车线

}
