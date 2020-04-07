package com.mt.tlstools.mapper.src;

import com.mt.tlstools.pojo.Device;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeviceMapper {
    List<Device> selectDevices();

}
