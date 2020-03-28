package com.mt.tlstools.config.redis;

import com.mt.tlstools.config.RedisChannelConstants;
import com.mt.tlstools.config.redis.listeners.RedisSubPreNormalMessageListener1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

import javax.annotation.Resource;

/**
 *项目名: tls
 *文件名: RedisTemplateConfig
 *创建者: mt-liuy liuyang@tjmeiteng.com
 *创建时间:2019/4/19 13:31
 *描述: pre往redis发送消息时用的 stringRedisTemplate value的序列化使用的 jackon   本系统同pre相同
 *
 *
 */
@Configuration
public class RedisListenerConfig {

    /**
     * pre loadline1 实时数据更改的监听
     */
    @Resource(name="normalListener1")
    private MessageListener normalListener1;

    /**
     * pre loadline1 报警通道的监听
     */
    @Resource(name="alarmListener1")
    private MessageListener alarmListener1;

    /**
     * pre loadline1 链路通道
     */
    @Resource(name="preStateListener1")
    private MessageListener preStateListener1;

    /**
     * pre loadline1 实时数据更改的监听
     */
    @Resource(name="normalListener2")
    private MessageListener normalListener2;

    /**
     * pre loadline1 报警通道的监听
     */
    @Resource(name="alarmListener2")
    private MessageListener alarmListener2;

    /**
     * pre loadline1 链路通道
     */
    @Resource(name="preStateListener2")
    private MessageListener preStateListener2;





    /**
     * @param redisTemplate
     * @return
     */
    @Bean("container-loadLine1")
    RedisMessageListenerContainer containerLoadLine1(@Autowired @Qualifier("redisTemplateLoadLine1") RedisTemplate redisTemplate) {

        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisTemplate.getConnectionFactory());
        container.addMessageListener(normalListener1, new ChannelTopic(RedisChannelConstants.PRE_POINT_MSG_CHANNEL));
        container.addMessageListener(alarmListener1, new ChannelTopic(RedisChannelConstants.PRE_ALARM_CHANNEL));
        container.addMessageListener(preStateListener1, new ChannelTopic(RedisChannelConstants.PRE_STATE_CHANNEL));
        return container;
    }

    /**
     * @param redisTemplate
     * @return
     */
    @Bean("container-loadLine2")
    RedisMessageListenerContainer containerLoadLine2(@Autowired @Qualifier("redisTemplateLoadLine2") RedisTemplate redisTemplate) {

        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisTemplate.getConnectionFactory());
        container.addMessageListener(normalListener2, new ChannelTopic(RedisChannelConstants.PRE_POINT_MSG_CHANNEL));
        container.addMessageListener(alarmListener2, new ChannelTopic(RedisChannelConstants.PRE_ALARM_CHANNEL));
        container.addMessageListener(preStateListener2, new ChannelTopic(RedisChannelConstants.PRE_STATE_CHANNEL));

        return container;
    }


}
