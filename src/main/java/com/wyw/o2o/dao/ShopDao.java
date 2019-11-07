package com.wyw.o2o.dao;

import com.wyw.o2o.entity.Shop;

/**店铺信息
 * @author wangyw
 * @date 2019/11/07
 */
public interface ShopDao {
    /**
     * 新增店铺
     * 1 成功 -1 失败
     */

    int insertShop(Shop shop);

    /**
     * 更新店铺信息
     * @param shop
     * @return
     */
    int updateShop(Shop shop);
}
