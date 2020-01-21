package com.wyw.o2o.service.impl;

import com.wyw.o2o.dao.ShopCategoryDao;
import com.wyw.o2o.entity.ShopCategory;
import com.wyw.o2o.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ${Description}
 *
 * @author wyw
 * @date 2020/01/20
 */
@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {

    @Autowired
    ShopCategoryDao shopCategoryDao;

    @Override
    public List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition) {
        return shopCategoryDao.queryShopCategory(shopCategoryCondition);
    }
}
