package com.mt.tlstools.config.redis.listeners;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.mt.tlstools.pojo.JsonPreStateClass;
import com.mt.tlstools.util.JacksonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名: mt-tls
 * 文件名: RedisSubPreStateMessageListener
 * 创建者: mt-liuy liuyang@tjmeiteng.com
 * 创建时间:2019/9/29 10:32
 * 描述: pre链路状态消息订阅通道  链路掉线报警
 */
@Slf4j
@Component("preStateListener1")
public class RedisSubPreStateMessageListener1 implements MessageListener {


    private RedisSerializer<?> serializer = new StringRedisSerializer();

    static volatile List<Integer> screenA = new ArrayList<Integer>() {{
        for (int i = 0; i < 10; i++)
            this.add(0);
    }};
    static volatile List<Integer> screenB = new ArrayList<Integer>() {{
        for (int i = 0; i < 10; i++)
            this.add(0);
    }};

    @Override
    public void onMessage(Message message, byte[] bytes) {
        Object body = serializer.deserialize(message.getBody());
        String msg = body.toString();
//        log.info("收到1#站pre传来的链路信息--->{}", body.toString());
        try {
            List<JsonPreStateClass> receiveDatas = null;
            if (msg.startsWith("[")) {
                receiveDatas = JacksonUtil.json2list(msg, JsonPreStateClass.class);
            } else if (msg.startsWith("{")) {
                receiveDatas = new ArrayList<>();
                receiveDatas.add(JacksonUtil.json2pojo(msg, JsonPreStateClass.class));
            } else {
//                log.error("接收到的消息不符合规范");
                throw new RuntimeException("接收到的消息不符合规范");
            }
            for (JsonPreStateClass receiveData : receiveDatas) {
                int stateId = receiveData.getStateId();
                int dacuId = receiveData.getDacuId();
                int modelId = receiveData.getModelId();
                String errMsg = receiveData.getCnMsg();
                switch (stateId) {
                    case 1:
                        handleOk(stateId, dacuId);
                        break;
                    case -1:
                        handleInitFail(stateId, dacuId);
                        break;
                    case 4:
                        log.error("点写入失败 {}", modelId);
                        break;
                    case 0:
//                        log.error("pre内核错误信息:{}", errMsg);
                        handleDiaoxian(stateId, dacuId);
                        break;
                }
            }
//            log.info("接收到redis消息{},json转换为{}", msg, receiveDatas);
        } catch (Exception e) {
            log.error("解析pre链路信息错误{}", e.getMessage());
        }
    }

    private void handleInitFail(int stateId, int dacuId) throws JsonProcessingException {
        log.error("主链路连接失败，dacuId=" + dacuId);
        switch (dacuId) {
            case 3:
//                log.error("Crevis模块初始化连接失败");
                break;
            case 8:
//                log.error("西克厚度雷达控制单元连接失败");
                break;
            case 11:
                break;
            case 12:
                break;
            case 13:
                break;
            case 14:
                break;
            case 15:
                break;
            case 16:
                break;
            case 17:
                break;
            case 18:
                break;
            case 19:
                break;
            case 20:
                break;
            case 31:
                break;
            case 32:
                break;
            case 33:
                break;
            case 34:
                break;
            case 35:
                break;
            case 36:
                break;
            case 37:
                break;
            case 38:
                break;
            case 39:
                break;
            case 40:
                break;
            case 21:
//                log.error("现场ABPLC连接失败");
                break;
        }
    }

    private void handleOk(int stateId, int dacuId) throws JsonProcessingException {
        log.error("主链路连接正常，dacuId=" + dacuId);
        switch (dacuId) {
            case 3:
                log.info("Crevis模块连接");
                break;
            case 8:
                log.info("西克厚度雷达控制单元连接");
                break;
            case 11:
                break;
            case 12:
                break;
            case 13:
                break;
            case 14:
                break;
            case 15:
                break;
            case 16:
                break;
            case 17:
                break;
            case 18:
                break;
            case 19:
                break;
            case 20:
                break;
            case 31:
                break;
            case 32:
                break;
            case 33:
                break;
            case 34:
                break;
            case 35:
                break;
            case 36:
                break;
            case 37:
                break;
            case 38:
                break;
            case 39:
                break;
            case 40:
                break;
            case 21:
                log.info("现场ABPLC连接");
                break;
        }
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void handleDiaoxian(int stateId, int dacuId) throws JsonProcessingException {
//        log.error("主链路掉线，dacuId=" + dacuId);
        switch (dacuId) {
            case 3:
//                log.error("Crevis模块掉线");
                break;
            case 8:
//                log.error("西克厚度雷达控制单元掉线");
                break;
            case 11:
                break;
            case 12:
                break;
            case 13:
                break;
            case 14:
                break;
            case 15:
                break;
            case 16:
                break;
            case 17:
                break;
            case 18:
                break;
            case 19:
                break;
            case 20:
                break;
            case 31:
                break;
            case 32:
                break;
            case 33:
                break;
            case 34:
                break;
            case 35:
                break;
            case 36:
                break;
            case 37:
                break;
            case 38:
                break;
            case 39:
                break;
            case 40:
                break;
            case 21:
//                log.error("现场ABPLC掉线");
                break;
        }
    }


}
