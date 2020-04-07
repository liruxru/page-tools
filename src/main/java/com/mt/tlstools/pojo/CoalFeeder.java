package com.mt.tlstools.pojo;

import lombok.Data;

/**
 * 给煤机编号
 */
@Data
public class CoalFeeder {
    private String coalFeederCode; //给煤机编号
    private Integer runStatusId;     // 给煤机运行状态
    private Boolean runStatus;     // 给煤机运行状态
    private Integer inputHzId;     // 给煤机运行状态
    private Float inputRunHz;            // 给煤机输入频率
    private Integer outputHzId;            // 给煤机输出频率
    private Float outputRunHz;            // 给煤机输出频率
    private Integer warningId;   //是否有故障
    private Boolean warning;   //是否有故障
    private Integer runId;
    private Integer stopId;
    private Integer resetId;
    private String coalBunker;
    private String loadLine;
}
