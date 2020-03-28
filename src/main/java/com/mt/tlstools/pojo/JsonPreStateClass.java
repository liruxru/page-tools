package com.mt.tlstools.pojo;

import lombok.Data;

/*
 *项目名: mt-tls
 *文件名: JsonPreStateClass
 *创建者: mt-liuy liuyang@tjmeiteng.com
 *创建时间:2019/10/9 13:56
 *描述: pre内核信息实体
 */
@Data
public class JsonPreStateClass {
    private int dacuId;
    private int modelId;
    private int stateId;
    private String cnMsg;
    private long timeSpan;
}
