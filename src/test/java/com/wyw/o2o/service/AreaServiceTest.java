package com.wyw.o2o.service;

import com.wyw.o2o.BaseTest;
import com.wyw.o2o.entity.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author wangyw
 * @date 2019/11/07
 */
public class AreaServiceTest extends BaseTest {

    @Autowired
    AreaService areaService;

    @Test
    public void areaServiceTest(){
        List<Area> areaList = areaService.getAreaList();
        assertEquals("西苑",areaList.get(0).getAreaName());
    }
}
