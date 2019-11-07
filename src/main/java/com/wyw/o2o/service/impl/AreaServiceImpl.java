package com.wyw.o2o.service.impl;

import com.wyw.o2o.dao.AreaDao;
import com.wyw.o2o.entity.Area;
import com.wyw.o2o.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangyw
 * @date 2019/11/07
 */
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }
}
