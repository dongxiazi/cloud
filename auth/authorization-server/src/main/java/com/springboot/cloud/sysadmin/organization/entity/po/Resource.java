package com.springboot.cloud.sysadmin.organization.entity.po;

import com.springboot.cloud.common.web.entity.po.BasePo;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: dongxiazi
 * @create: 2020/12/25 14:05
 */
@Data
@NoArgsConstructor
public class Resource extends BasePo {
    private String code;
    private String name;
    private String type;
    private String url;
    private String method;
    private String description;
}
