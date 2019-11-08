package com.wyw.o2o.Exception;

/**
 * 店铺操作异常
 *
 * @author wangyw
 * @date 2019/11/08
 */
public class ShopOperationException extends RuntimeException{
    public ShopOperationException(String msg) {
        super(msg);
    }
}
