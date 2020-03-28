package com.mt.tlstools.document;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/*
 *项目名: tls
 *文件名: ActualDataOfPre
 *创建者: mt-liuy liuyang@tjmeiteng.com
 *创建时间:2019/4/20 10:42
 *描述: pre服务存储的实时数据，程序启动时需要加载该库的所有实时数据
 */
@Data
@Document(collection = "CfgDevPointDataRt")
public class ActualDataOfPre implements Serializable {
    @Field("PointId")
    private Integer pointId;
    @Field("DataValue")
    private Number  dataValue;
    @Field("TimeStamp")
    private long updateTime;
}