package com.wyw.o2o.util;

import javax.servlet.http.HttpServletRequest;

/**
 * 处理http请求
 *
 * @author wangyw
 * @date 2019/11/10
 */
public class HttpServletRequestUtil {

    //将request中参数转换为整型
    public static int getInt(HttpServletRequest request,String key){
        try{
            return Integer.decode(request.getParameter(key));
        } catch(Exception e){
            return -1;
        }
    }

    public static long getLong(HttpServletRequest request,String key){
        try{
            return Long.decode(request.getParameter(key));
        } catch(Exception e){
            return -1;
        }
    }

    public static double getDouble(HttpServletRequest request,String key){
        try{
            return Double.valueOf(request.getParameter(key));
        } catch(Exception e){
            return -1d;
        }
    }

    public static boolean getBoolean(HttpServletRequest request,String key){
        try{
            return Boolean.valueOf(request.getParameter(key));
        } catch(Exception e){
            return false;
        }
    }

    public static String getString(HttpServletRequest request,String key){
        try {
            String result = request.getParameter(key);
            if(null != result){
                result = result.trim();
            }
            if("".equals(result)){
                result = null;
            }
            return result;
        } catch (Exception e){
            return null;
        }
    }
}
