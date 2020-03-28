package com.mt.tlstools.pojo;

import lombok.Data;

@Data
public class TaskVo {
    private String taskNum;
    private String trainNum;
//    private String carType;
    private int trainNumTotal;
    private String loadLineName;
    private String loadLine;
    private int targetCalorificValue; // 目标热值
    private int loadingMode; // 装车方式
    private float loadUseTime;
}
