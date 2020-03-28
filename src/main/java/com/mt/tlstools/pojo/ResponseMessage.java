package com.mt.tlstools.pojo;


import lombok.Data;

import java.io.Serializable;
import java.util.Map;
@Data
public class ResponseMessage<T> implements Serializable {
    private String msg;
    private Integer code;
    private Map<String, T> data;


    /**
     * 0 标识无异常
     *
     * @return
     */
    public static ResponseMessage ok() {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.code(0).msg("ok").data(null);
        return responseMessage;
    }

    /**
     * 创建一个空的 ResponseMessage
     *
     * @return
     */
    public static ResponseMessage createEmptyResponse() {
        return new ResponseMessage();
    }


    public static ResponseMessage fail(int code, String msg) {
        return  createEmptyResponse().code(code).msg(msg).data(null);
    }


    /**
     * 私有化构造器
     */
    private ResponseMessage() {
    }

    public ResponseMessage code(int code) {
        this.code = code;
        return this;
    }

    public ResponseMessage msg(String msg) {
        this.msg = msg;
        return this;
    }

    public ResponseMessage data(Map<String, T> data) {
        this.data = data;
        return this;
    }
}
