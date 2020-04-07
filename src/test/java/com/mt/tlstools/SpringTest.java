package com.mt.tlstools;

import com.mt.tlstools.mapper.src.CoalFeederMapper;
import com.mt.tlstools.pojo.CoalFeeder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
//@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TlsToolsApplication.class})// 指定启动类
public class SpringTest {
    @Autowired
    private CoalFeederMapper coalFeederMapper;
    @Test
    public void test(){
        List<CoalFeeder> coalFeeders = coalFeederMapper.selectCoalByLoadLine("400012");
        System.out.println(coalFeeders);
    }
}
