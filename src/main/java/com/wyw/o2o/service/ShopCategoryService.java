package com.wyw.o2o.service;

import com.wyw.o2o.entity.ShopCategory;

import java.util.List;

/**
 * ${Description}
 *
 * @author wyw
 * @date 2020/01/20
 */
public interface ShopCategoryService {
    List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition);
}
