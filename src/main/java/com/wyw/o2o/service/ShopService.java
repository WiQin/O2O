package com.wyw.o2o.service;

import com.wyw.o2o.dto.ShopExecution;
import com.wyw.o2o.entity.Shop;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


/**
 * @author wangyw
 * @date 2019/11/08
 */
public interface ShopService {
    /**
     * 创建店铺
     * @param shop
     * @param shopImg
     * @return
     */
    ShopExecution addShop(Shop shop, CommonsMultipartFile shopImg);
}
