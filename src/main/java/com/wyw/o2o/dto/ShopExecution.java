package com.wyw.o2o.dto;

import com.wyw.o2o.entity.Shop;
import com.wyw.o2o.enums.EnumShopState;

import java.util.List;

/**
 * @author wangyw
 * @date 2019/11/08
 */
public class ShopExecution {

    /**
     * 结果状态
     */
    private int state;
    /**
     * 状态标识
     */
    private String stateInfo;
    /**
     * 店铺数量
     */
    private int count;
    /**
     * 操作店铺
     */
    private Shop shop;
    /**
     * 查询店铺列表用
     */
    private List<Shop> shopList;

    public ShopExecution() {
    }

    //店铺操作失败构造器
    public ShopExecution(EnumShopState enumState){
        this.state = enumState.getState();
        this.stateInfo = enumState.getStateInfo();
    }

    //店铺操作成功构造器
    public ShopExecution(EnumShopState enumState,Shop shop) {
        this.state = enumState.getState();
        this.stateInfo = enumState.getStateInfo();
        this.shop = shop;
    }

    //店铺操作成功构造器
    public ShopExecution(EnumShopState enumState,List<Shop> shopList) {
        this.state = enumState.getState();
        this.stateInfo = enumState.getStateInfo();
        this.shopList = shopList;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public List<Shop> getShopList() {
        return shopList;
    }

    public void setShopList(List<Shop> shopList) {
        this.shopList = shopList;
    }
}
