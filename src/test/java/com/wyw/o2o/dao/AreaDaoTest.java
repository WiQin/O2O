package com.wyw.o2o.dao;

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
public class AreaDaoTest extends BaseTest {

    @Autowired
    AreaDao areaDao;

    @Test
    public void testQueryArea(){
        List<Area> areaList = areaDao.queryArea();
        assertEquals(2,areaList);//验证条数是否与实际相同
    }
}
