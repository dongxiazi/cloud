package com.springboot.cloud.common.web.entity.vo;

import com.springboot.cloud.common.web.entity.po.BasePo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description:
 * @author: dongxiazi
 * @create: 2020/12/23 11:36
 */
@Data
@NoArgsConstructor
public class BaseVo<T extends BasePo> {
    private String id;
}
