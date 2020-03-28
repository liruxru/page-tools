package com.mt.tlstools.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainPosition {
    private double carTail;
    private double carHead;
    private int index; // 车厢序号
    private double carLong;
}
