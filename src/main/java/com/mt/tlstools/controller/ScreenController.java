package com.mt.tlstools.controller;

import com.mt.tlstools.config.ConstantConfig;
import com.mt.tlstools.config.RedisPointConfig;
import com.mt.tlstools.pojo.CarriageCoordinate;
import com.mt.tlstools.pojo.TrainPosition;
import com.mt.tlstools.util.JacksonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@Slf4j
public class ScreenController {
    @Autowired@Qualifier("redisTemplateLoadLine1")
    private RedisTemplate<String, String> redisTemplateLoadLine1;
    @Autowired@Qualifier("redisTemplateLoadLine2")
    private RedisTemplate<String, String> redisTemplateLoadLine2;

    /**
     *
     * @param loadLine       装车线
     * @param activeScreen   1为主光幕   2为备份光幕
     * @return
     */
    @RequestMapping("screenData")
    @ResponseBody
    public List<Integer> getAllPoints(String loadLine,int activeScreen) {
        List<String> keys = new ArrayList<>();
        if(activeScreen==2){
            // 备份光幕
            for (int i = 0; i < 400; i++) {
                keys.add(3174 + i + "");
            }
        }else{
            // 主光幕
            for (int i = 0; i < 400; i++) {
                keys.add(1174 + i + "");
            }
        }


        List<String> strings = null;
        if(ConstantConfig.LOAD_LINE_01.equals(loadLine)){
            strings = redisTemplateLoadLine1.opsForValue().multiGet(keys);
        }else if(ConstantConfig.LOAD_LINE_02.equals(loadLine)){
            strings = redisTemplateLoadLine2.opsForValue().multiGet(keys);
        }else{
            log.error("错误的参数");
            return null;
        }


        List<Integer> points = new ArrayList<>();
        for (String string : strings) {
            if (null == string) {
                points.add(null);
            } else if (Boolean.valueOf(string)) {
                points.add(1);
            } else if (!Boolean.valueOf(string)) {

                points.add(0);
            } else {
                // nothing
            }
        }
        return points;
    }
    @RequestMapping("getTrainV")
    @ResponseBody
    public String getTrainV(String loadLine){
        Object o = null;
        if(ConstantConfig.LOAD_LINE_01.equals(loadLine)){
            o  =redisTemplateLoadLine1.opsForValue().get(RedisPointConfig.TRAIN_SPEED_LOC);
        }else if(ConstantConfig.LOAD_LINE_02.equals(loadLine)){
            o  =redisTemplateLoadLine2.opsForValue().get(RedisPointConfig.TRAIN_SPEED_LOC);
        }else{
            log.error("错误的参数");
            return null;
        }

        return o==null?"":o.toString();
    }
    @RequestMapping("getAllPosition")
    @ResponseBody
    public List<TrainPosition>  getAllPosition(String loadLine){
        List<TrainPosition> positions =new ArrayList<>();
        Object o = null;
        if(ConstantConfig.LOAD_LINE_01.equals(loadLine)){
            o  = redisTemplateLoadLine1.opsForValue().get(RedisPointConfig.TRAIN_POSITION_LOC);
        }else if(ConstantConfig.LOAD_LINE_02.equals(loadLine)){
            o  = redisTemplateLoadLine2.opsForValue().get(RedisPointConfig.TRAIN_POSITION_LOC);
        }else{
            log.error("错误的参数");
            return null;
        }

        if(null!=o&&!"".equals(o)) {
            try {

                List<CarriageCoordinate> osss =  JacksonUtil.json2list(o.toString(),CarriageCoordinate.class);
                log.debug("redis中缓存的车厢位置信息为{}",osss);
//                osss.sort(Comparator.comparingInt(CTrainPosition::getIndex));
                for (CarriageCoordinate cTrainPosition : osss) {
                    if(cTrainPosition.getIndex()!=0){
                        TrainPosition trainPosition = new TrainPosition();
                        trainPosition.setCarHead(cTrainPosition.getHead());
                        trainPosition.setCarTail(cTrainPosition.getTail());
                        trainPosition.setIndex(cTrainPosition.getIndex());
                        positions.add(trainPosition);
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return  positions;
    }
}
