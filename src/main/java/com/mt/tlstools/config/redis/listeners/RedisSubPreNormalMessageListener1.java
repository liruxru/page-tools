package com.mt.tlstools.config.redis.listeners;

import com.mt.tlstools.corecache.CacheLoadLine;
import com.mt.tlstools.corecache.CacheLoadLine1;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.Map;

/*
 *项目名: tls
 *文件名: RedisSubListenerConfig
 *创建者: mt-liuy liuyang@tjmeiteng.com
 *创建时间:2019/4/19 13:35
 *描述: pre数据通道订阅
 */
@Component("normalListener1")
@Slf4j
public class RedisSubPreNormalMessageListener1 extends AbstractHandlerDataListener {

    @Autowired
    private CacheLoadLine1 cacheLoadLine1;

    private RedisSerializer<?> serializer = new StringRedisSerializer();
    @Override
    public void onMessage(Message message, byte[] bytes) {
        Object body = serializer.deserialize(message.getBody());
        String msg = body.toString();
        try {
            Map<Integer, Number> dataMap = getIntegerNumberMap(msg);
            cacheLoadLine1.updateActualData(dataMap);
        } catch (Exception e) {

//            log.error("更新一号站数据失败{}",e.getMessage());
        }

    }
}
