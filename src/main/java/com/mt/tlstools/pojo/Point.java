package com.mt.tlstools.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Point implements Serializable {
    private Integer pointId;
    private Number pointValue;
    private String pointName;
    private String loadLine;
}
