package com.mt.tlstools.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 项目名: tls
 * 文件名: CarriageCoordinate
 * 创建者: Administrator
 * 创建时间: 2019/6/5 9:50
 * 描述: 光幕输出的车厢坐标信息
 **/
@Data
public class CarriageCoordinate implements Serializable {

    // 光幕中的首坐标
    private Float head;
    // 光幕中的尾坐标
    private Float tail;

    private int index;
}
