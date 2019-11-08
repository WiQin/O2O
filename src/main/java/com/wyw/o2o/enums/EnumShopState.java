package com.wyw.o2o.enums;

/**
 * 店铺状态
 *
 * @author wangyw
 * @date 2019/11/08
 */
public enum EnumShopState {
    CHECK(0, "审核中"),
    OFFLINE(-1, "非法店铺"),
    SUCCESS(1, "操作成功"),
    PASS(2, "通过认证"),
    INNER_ERROR(-1001, "内部系统错误"),
    NULL_SHOP_ID(-1002, "shop_id为空"),
    NULL_SHOP(-1003,"店铺信息为空");

    private int state;
    private String stateInfo;

    private EnumShopState(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    /**
     * 依据传入的state返回相应的enum值
     *
     * @return
     */
    public static EnumShopState valueOf(int state) {
        for (EnumShopState enumState : values()) {
            if (enumState.getState() == state) {
                return enumState;
            }
        }
        return null;
    }

    public int getState() {
        return state;
    }

    private void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    private void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }
}
