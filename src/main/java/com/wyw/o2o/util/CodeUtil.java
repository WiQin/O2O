package com.wyw.o2o.util;

import com.google.code.kaptcha.Constants;

import javax.servlet.http.HttpServletRequest;

/**
 * 验证码校验
 *
 * @author wyw
 * @date 2020/01/21
 */
public class CodeUtil {

    public static boolean checkVertifyCode(HttpServletRequest request){
        String vertifyCodeExpected = (String)request.getSession().getAttribute(Constants.KAPTCHA_SESSION_CONFIG_KEY);

        String vertifyCodeActual = HttpServletRequestUtil.getString(request,"vertifyCodeActual");

        if(null == vertifyCodeActual || !vertifyCodeActual.equals(vertifyCodeExpected)){
            return false;
        }
        return true;
    }
}
