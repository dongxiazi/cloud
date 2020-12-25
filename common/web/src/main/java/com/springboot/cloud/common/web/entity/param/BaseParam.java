package com.springboot.cloud.common.web.entity.param;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.springboot.cloud.common.web.entity.po.BasePo;
import lombok.Data;

import java.util.Date;

/**
 * @description:
 * @author: dongxiazi
 * @create: 2020/12/23 11:38
 */
@Data
public class BaseParam<T extends BasePo> {
    private Date createdTimeStart;
    private Date createdTimeEnd;

    public QueryWrapper<T> build(){
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge(null!=createdTimeStart,"created_time",createdTimeStart)
                .le(null!=createdTimeEnd,"created_time",createdTimeEnd);
        return queryWrapper;
    }
}
