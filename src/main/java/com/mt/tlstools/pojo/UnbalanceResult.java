package com.mt.tlstools.pojo;

import lombok.Data;

/**
 * 项目名: tls
 * 文件名: UnbalanceInfo
 * 创建者: Administrator
 * 创建时间: 2019.11.28 18:40
 * 描述:
 **/
@Data
public class UnbalanceResult {

    // 距离车头的位置
    private String position;

    // 偏载值
    private String unbalanceValue;
}
