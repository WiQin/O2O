package com.wyw.o2o.controller.shopadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * ${Description}
 *
 * @author wyw
 * @date 2020/01/21
 */
@Controller
@RequestMapping(value = "shopadmin",method = RequestMethod.GET)
public class ShopAdminController {

    /**
     * 返回店铺信息的页面路径
     * （spring-web.xml视图解析器）
     * @return
     */
    @RequestMapping(value = "/shopoperation")
    public String shopOperation(){
        //html文件的路径和文件名（无后缀）
        return "shop/shopedit";
    }

}
