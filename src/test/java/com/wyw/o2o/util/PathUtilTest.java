package com.wyw.o2o.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangyw
 * @date 2019/11/08
 */
public class PathUtilTest {

    @Test
    public void pathTest(){

//        System.setProperty("file.seperator","\\");
//        System.setProperty("os.name","windows");
//
//        System.out.println(PathUtil.getImgBasePath());
//
//        System.out.println(PathUtil.getShopImgPath(1L));

        String property = System.getProperty("file.separator");
        System.out.println(property);
    }

}