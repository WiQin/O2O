package com.wyw.o2o.service.impl;

import com.wyw.o2o.Exception.ShopOperationException;
import com.wyw.o2o.dao.ShopDao;
import com.wyw.o2o.dto.ShopExecution;
import com.wyw.o2o.entity.Shop;
import com.wyw.o2o.enums.EnumShopState;
import com.wyw.o2o.service.ShopService;
import com.wyw.o2o.util.ImagUtil;
import com.wyw.o2o.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.util.Date;

/**
 * @author wangyw
 * @date 2019/11/08
 */
@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopDao shopDao;

    /**
     * 新增店铺
     * Transactional注解进行事务管理（任何一步操作失败都返回）
     *
     * @param shop
     * @param shopImg
     * @return
     */
    @Override
    @Transactional
    public ShopExecution addShop(Shop shop, CommonsMultipartFile shopImg) {
        if (shop == null) {
            return new ShopExecution(EnumShopState.NULL_SHOP);
        }
        //todo shop其他字段的判断(是否为空，是否非法)

        //添加店铺
        try {
            //初始化参数
            //状态 审核中
            shop.setStatus(0);
            //创建时间
            shop.setCreateTime(new Date());
            //修改时间
            shop.setUpdateTime(new Date());

            //数据库中插入店铺信息
            int effectNum = shopDao.insertShop(shop);
            if (effectNum <= 0) {
                //抛出RuntimeException或继承RuntimeException的类时，事务才会终止并且回滚
                throw new ShopOperationException("店铺创建失败");
            } else {
                //判断传入图片是否为空，不为空将店铺图片存到对应目录
                if (null != shopImg) {
                    //存储图片
                    try {
                        addShopImg(shop, shopImg);
                    } catch (Exception e) {
                        throw new ShopOperationException("add ShopImg error"+e.getMessage());
                    }
                    //更新店铺图片地址
                    effectNum = shopDao.updateShop(shop);
                    if(effectNum <= 0){
                        throw new ShopOperationException("更新图片地址失败");
                    }
                }
            }
        } catch (Exception e) {
            throw new ShopOperationException("addShop error" + e.getMessage());
        }
        return new ShopExecution(EnumShopState.CHECK,shop);
    }

    private void addShopImg(Shop shop,CommonsMultipartFile shopImg){
        //获取shop图片相对值路径
        String dest = PathUtil.getShopImgPath(shop.getId());
        String shopAddr = ImagUtil.generateThumbnail(shopImg,dest);
        shop.setImg(shopAddr);
    }
}
