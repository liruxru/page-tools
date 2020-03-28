package com.mt.tlstools.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/*
 *项目名: tls
 *文件名: SendPreCommandPo
 *创建者: mt-liuy liuyang@tjmeiteng.com
 *创建时间:2019/4/22 10:47
 *描述: 发送到redis指令的po实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendPreCommandPo implements Serializable {
    @JsonProperty("id_Point")
    private Number pointId;
    @JsonProperty("rawValue")
    private Object rawValue;
    private Long timeSpan; //时间戳

}
