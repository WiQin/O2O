package com.wyw.o2o.service;

import com.wyw.o2o.dto.ShopExecution;
import com.wyw.o2o.entity.Shop;

import java.io.File;
import java.io.InputStream;


/**
 * @author wangyw
 * @date 2019/11/08
 */
public interface ShopService {
    /**
     * 创建店铺
     * @param shop  店铺信息
     * @param shopImgInputStream  店铺图片文件输入流
     * @param fileaName  文件名
     * @return
     */
    ShopExecution addShop(Shop shop, InputStream shopImgInputStream,String fileaName);
}
