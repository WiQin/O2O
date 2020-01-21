package com.wyw.o2o.service;

import com.wyw.o2o.BaseTest;
import com.wyw.o2o.dto.ShopExecution;
import com.wyw.o2o.entity.Area;
import com.wyw.o2o.entity.PersonInfo;
import com.wyw.o2o.entity.Shop;
import com.wyw.o2o.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.Date;

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
        PersonInfo owner = new PersonInfo();
        owner.setUserId(1L);
        ShopCategory shopCategory = new ShopCategory();
        shopCategory.setShopCategoryId(1L);
        Area area = new Area();
        area.setAreaId(2);
        Shop shop = new Shop();
        shop.setOwner(owner);
        shop.setShopCategory(shopCategory);
        shop.setArea(area);
        shop.setShopName("测试店铺1");
        shop.setShopAddr("XXX-XXX-XXX");
        shop.setShopDesc("测试新增店铺功能");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(1);
        shop.setAdvice("审核中");

//        File image = new File("路径");
//        CommonsMultipartFile file = new CommonsMultipartFile();

//        ShopExecution shopExecution = shopService.addShop(shop, file);
//        assertEquals(0,shopExecution.getState());
    }
}
