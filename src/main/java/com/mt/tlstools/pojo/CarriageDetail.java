package com.mt.tlstools.pojo;

import lombok.Data;

@Data
public class CarriageDetail {

    // 车厢信息ID
    private String carriageId;
    private String taskNum;
    private String trainNum;
    private int orderNum;
    // 实际载重
    private Float actualLoad = 0.0f;

    // 实际毛重
    private Float grossWeight;

    // 误差
    private Float deviation = 0.0f;
    // 偏载量
    private Float partialLoad;

    // 超载量
    private Float overloadCapacity;

    // 每节装车平均车速
    private Float averageSpeed;
    // 车厢装车状态  车厢装车状态 0:空 1:正在装 2:装完
    private String loadStatus;

    // 手自动状态  0 手动  1 自动   0:手动 1:自动
    private String autoStatus;

    // 装车用时
    private Float loadUseTime = 0.0f;
}
