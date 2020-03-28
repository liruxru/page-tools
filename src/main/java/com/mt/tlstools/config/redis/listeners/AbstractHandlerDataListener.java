package com.mt.tlstools.config.redis.listeners;

import com.mt.tlstools.pojo.ReceiveData;
import com.mt.tlstools.util.JacksonUtil;
import com.mt.tlstools.util.MyStringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
 *项目名: mt-tls
 *文件名: AbstractHandlerDataListener
 *创建者: mt-liuy liuyang@tjmeiteng.com
 *创建时间:2019/10/9 13:26
 *描述: 抽象的数据处理
 */
@Slf4j
@Component
public abstract class AbstractHandlerDataListener implements MessageListener {


    protected Map<Integer, Number> getIntegerNumberMap( String msg) throws Exception {
        List<ReceiveData> receiveDatas = null;
        if(msg.startsWith("[")){
            receiveDatas = JacksonUtil.json2list(msg, ReceiveData.class);
        }else if(msg.startsWith("{")){
            receiveDatas = new ArrayList<>();
            receiveDatas.add(JacksonUtil.json2pojo(msg, ReceiveData.class));
        }else{
            log.error("接收到的消息不符合规范");
            throw new RuntimeException("接收到的消息不符合规范");
        }

        log.debug("接收到redis消息{},json转换为{}",msg,receiveDatas);
        // 将receiveData 转换为map

        Map<Integer,Number> dataMap = new ConcurrentHashMap<>();
        for (ReceiveData receiveData : receiveDatas) {
            Number value = MyStringUtils.parseString2Number(receiveData.getRawValue());
            dataMap.put(receiveData.getPointId(),value);
        }
        return dataMap;
    }
}
