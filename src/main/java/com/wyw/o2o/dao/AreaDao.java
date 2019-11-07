package com.wyw.o2o.dao;

import com.wyw.o2o.entity.Area;

import java.util.List;

/**
 * 区域信息
 *
 * @author wangyw
 * @date 2019/11/07
 */
public interface AreaDao {
    /**
     * 列出区域列表
     * @return areaList
     */
    List<Area> queryArea();
}
