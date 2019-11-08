package com.wyw.o2o.util;

/**
 * 路径处理
 *
 * @author wangyw
 * @date 2019/11/08
 */
public class PathUtil {
    public static String seperator = System.getProperty("file.seperator");

    /**
     * 项目图片根路径
     * @return
     */
    public static String getImgBasePath(){
        String os = System.getProperty("os.name");
        String basePath;
        if(os.toLowerCase().startsWith("win")){
            basePath = "d:/Users/Pictures/img/";
        } else {
            basePath = "/home/wyw/img/";
        }
        basePath = basePath.replace("/",seperator);
        return basePath;
    }

    /**
     * 店铺图片子路径
     * @param shopId
     * @return
     */
    public static String getShopImgPath(Long shopId){
        String imgPath = "upload/item/shop/"+shopId+"/";
        return imgPath.replace("/",seperator);
    }
}
