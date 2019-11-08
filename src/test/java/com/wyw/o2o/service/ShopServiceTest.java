package com.wyw.o2o.service;

import com.wyw.o2o.BaseTest;
import com.wyw.o2o.dto.ShopExecution;
import com.wyw.o2o.entity.Shop;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;

import static org.junit.Assert.assertEquals;

/**
 * @author wangyw
 * @date 2019/11/08
 */
public class ShopServiceTest extends BaseTest {

    @Autowired
    private ShopService shopService;

    @Test
    public void addShopTest(){
        Shop shop = new Shop();

//        assertEquals(0,execution.getState());
    }
}
