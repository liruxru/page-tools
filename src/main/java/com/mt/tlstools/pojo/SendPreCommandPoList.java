package com.mt.tlstools.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SendPreCommandPoList {
    @JsonProperty("id_Point")
    private Number pointId;
    private Number pointIdEnd;
    @JsonProperty("rawValue")
    private Object rawValue;
    private Long timeSpan; //时间戳
}
