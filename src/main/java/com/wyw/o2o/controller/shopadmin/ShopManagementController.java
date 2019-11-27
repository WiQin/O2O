package com.wyw.o2o.controller.shopadmin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wyw.o2o.dto.ShopExecution;
import com.wyw.o2o.entity.PersonInfo;
import com.wyw.o2o.entity.Shop;
import com.wyw.o2o.enums.EnumShopState;
import com.wyw.o2o.service.ShopService;
import com.wyw.o2o.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 店铺管理
 *
 * @author wangyw
 * @date 2019/11/10
 */
@Controller
@RequestMapping("/shopadmin")
public class ShopManagementController {

    @Autowired
    ShopService shopService;

    @RequestMapping(value = "/registershop",method = RequestMethod.POST)
    @ResponseBody
    private Map<String,Object> registerShop(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<>();
        //接收并转换响应的参数（店铺信息，图片信息）
        //获取前段传来的店铺信息，转换为实体类
        String shopStr = HttpServletRequestUtil.getString(request, "shopStr");
        ObjectMapper mapper = new ObjectMapper();
        Shop shop;
        try{
            shop = mapper.readValue(shopStr,Shop.class);
        } catch (Exception e){
            modelMap.put("success",false);
            modelMap.put("errMsg",e.toString());
            return  modelMap;
        }
        //接收图片信息
        //接收图片文件流
        CommonsMultipartFile shopImg = null;
        //文件上传解析器，解析request中文件信息
        CommonsMultipartResolver resolver = new CommonsMultipartResolver(
                request.getSession().getServletContext()
        );
        //判断request是否有上传文件流
        if(resolver.isMultipart(request)){
            //将request请求做强制转换，以便提取文件流信息
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
            shopImg = (CommonsMultipartFile) multipartHttpServletRequest.getFile("shopImg");
        }else{
            modelMap.put("success",false);
            modelMap.put("errMsg","上传图片不能为空");
            return modelMap;
        }
        //注册店铺
        if(null != shop && null != shopImg){
            //不依赖前段传值
            //owner通过session会话获取  todo  添加session
            PersonInfo owner = new PersonInfo();
            owner.setUserId(1L);
            shop.setOwner(owner);

            ShopExecution se = shopService.addShop(shop,shopImg);
            if(se.getState() == EnumShopState.CHECK.getState()){
                modelMap.put("success",true);
            }else{
                modelMap.put("success",false);
                modelMap.put("errMsg",se.getState());
            }
            return modelMap;
        }else{
            modelMap.put("success",false);
            modelMap.put("errMsg","请填写店铺信息");
            return  modelMap;
        }
        //返回结果
    }

    private static void inputStreamToFile(InputStream ins, File file){
        FileOutputStream os = null;
        try {
            os = new FileOutputStream(file);
            int byteRead;
            byte[] buffer = new byte[1024];
            //循环将ins中的数据读入buffer[]中
            while ((byteRead = ins.read(buffer)) != -1){
                //将buffer中的内容写入输出流
                os.write(buffer,0,byteRead);
            }
        }catch (Exception e){
            throw new RuntimeException("调用inputStreamToFile产生异常："+e.getMessage());
        } finally {
            try {
                if(null != os){
                    os.close();
                }
                if(null != ins){
                    ins.close();
                }
            }catch(IOException e){
                throw new RuntimeException("调用inputStreamToFile关闭io产生异常："+e.getMessage());
            }
        }
    }
}
