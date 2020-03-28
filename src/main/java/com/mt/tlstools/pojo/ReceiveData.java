package com.mt.tlstools.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/*
 *项目名: tls
 *文件名: ReceiveData
 *创建者: mt-liuy liuyang@tjmeiteng.com
 *创建时间:2019/4/19 17:13
 *描述: TODO
 */
@Data
public class ReceiveData {
    @JsonProperty("id_Point")
    private Integer pointId;
    @JsonProperty("rawValue")
    private String rawValue;
    @JsonProperty("dataValue")
    private String dataValue;
    private long timeSpan; //时间戳
}
