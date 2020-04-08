package com.mt.tlstools.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Device implements Serializable {
    private int deviceId;
    private String deviceName;
}
