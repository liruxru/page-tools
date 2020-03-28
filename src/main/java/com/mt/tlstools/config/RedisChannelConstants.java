package com.mt.tlstools.config;

/*
 *项目名: tls
 *文件名: RedisChannelConstants
 *创建者: mt-liuy liuyang@tjmeiteng.com
 *创建时间:2019/6/5 10:37
 *描述: 系统关注的通道的配置
 */
public class RedisChannelConstants {
    /**
     * pre数据通道
     */
    public static final String PRE_POINT_MSG_CHANNEL= "sendChannel";
    /**
     * 向pre发送命令的通道
     */
    public static final String PRE_COMMAND_CHANNEL= "receiveChannel";
    /**
     * 接收pre报警的通道
     */
    public static final String PRE_ALARM_CHANNEL= "sendAlarmChannel";
    /**
     * 接收pre的链路通道 sendPreStateChannel
     */
    public static final String PRE_STATE_CHANNEL= "sendPreStateChannel";



}
