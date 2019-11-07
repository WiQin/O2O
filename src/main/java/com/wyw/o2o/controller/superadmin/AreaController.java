package com.wyw.o2o.controller.superadmin;

import com.wyw.o2o.entity.Area;
import com.wyw.o2o.service.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangyw
 * @date 2019/11/07
 */
@Controller
@RequestMapping("/superadmin")
public class AreaController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AreaController.class);

    @Autowired
    AreaService areaService;

    @RequestMapping(value = "/listarea",method = RequestMethod.GET)
    @ResponseBody
    private Map<String,Object> listArea(){
        LOGGER.info("===start===");
        long start = System.currentTimeMillis();
        Map<String,Object> map = new HashMap<>(16);
        List<Area> list;

        try{
            list = areaService.getAreaList();
            map.put("rows",list);
            map.put("total",list.size());
        } catch(Exception e){
            e.printStackTrace();
            map.put("code",false);
            map.put("msg",e.toString());
            LOGGER.error(e.toString());
        }
        long end = System.currentTimeMillis();
        LOGGER.info("===end===");
        LOGGER.debug("costTime:[{}ms]",end-start);
        return map;

    }
}
