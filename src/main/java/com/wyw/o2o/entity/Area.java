package com.wyw.o2o.entity;

import java.util.Date;

/**
 * 区域信息
 *
 * @author wangyw
 * @date 2019/09/21
 */
public class Area {
    private Integer areaId;//id

    private Integer areaName;//区域名称

    private Integer priority;//权重

    private Date createTime;//创建时间

    private Date UpdateTime;//更新时间

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getAreaName() {
        return areaName;
    }

    public void setAreaName(Integer areaName) {
        this.areaName = areaName;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return UpdateTime;
    }

    public void setUpdateTime(Date updateTime) {
        UpdateTime = updateTime;
    }
}
