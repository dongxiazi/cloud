package com.springboot.cloud.common.web.entity.form;

import com.springboot.cloud.common.web.entity.po.BasePo;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

/**
 * @description:
 * @author: dongxiazi
 * @create: 2020/12/23 11:42
 */
@Data
@ApiModel
@Slf4j
public class BaseForm<T extends BasePo> {
    private String username;//用户名


    /**
     * From转化为Po，进行后续业务处理
     *
     * @param clazz
     * @return
     */
    public T toPo(Class<T> clazz) {
        T t = BeanUtils.instantiateClass(clazz);
        BeanUtils.copyProperties(this, t);
        return t;
    }

    /**
     * From转化为Po，进行后续业务处理
     *
     * @param id
     * @param clazz
     * @return
     */
    public T toPo(String id, Class<T> clazz) {
        T t = BeanUtils.instantiateClass(clazz);
        BeanUtils.copyProperties(this, t);
        t.setId(id);
        return t;
    }
}
