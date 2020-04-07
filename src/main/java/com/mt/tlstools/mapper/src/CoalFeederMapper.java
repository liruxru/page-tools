package com.mt.tlstools.mapper.src;

import com.mt.tlstools.pojo.CoalFeeder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CoalFeederMapper {
    List<CoalFeeder> selectCoalByLoadLine(String loadLine);
}
