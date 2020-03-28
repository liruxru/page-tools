package com.mt.tlstools.util;

import java.text.DecimalFormat;
import java.util.UUID;

/*
 *项目名: tls
 *文件名: MyStringUtils
 *创建者: mt-liuy liuyang@tjmeiteng.com
 *创建时间:2019/4/20 11:21
 *描述: TODO
 */
public class MyStringUtils {

    /**
     * 将字符串转换为Number
     * @param str
     * @return
     */
    public static Number parseString2Number(String str){
        if(null==str||"".equals(str)||str.contains("[")||str.contains("{")) return null;
        if("true".equalsIgnoreCase(str)){
            return 1;
        }else if("false".equalsIgnoreCase(str)){
            return 0;
        }else if(str.contains(".")){
            return Double.parseDouble(str);
        }else{
            return Integer.parseInt(str);
        }

    }

    public static String fromatString2Num(String valueOf) {
        if(null==valueOf||"null".equals(valueOf)){
            return null;
        }else{
            DecimalFormat format = new DecimalFormat("#.##");
            return format.format(Float.valueOf(valueOf));
        }
    }

    public static String valueOf(Object obj) {
        return (obj == null) ? null : obj.toString();
    }

    public static String uuid() {
        return UUID.randomUUID().toString();
    }
}
