package com.mt.tlstools.mapper.src;

import com.mt.tlstools.pojo.Device;
import com.mt.tlstools.pojo.Point;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@Mapper
public interface DeviceMapper {
    @Cacheable(value = "device")
    List<Device> selectDevices();
    List<Point> selectPoints(int[] deviceIds);
    @Cacheable(value = "orPoint")
    List<Point> selectOnlyReadPoints(int[] deviceIds);
    @Cacheable(value = "wrPoint")
    List<Point> selectReadWritePoints(int[] deviceIds);

}
