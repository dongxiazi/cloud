package com.springboot.cloud.auth.authentication.service;

import com.springboot.cloud.sysadmin.organization.entity.po.Resource;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

/**
 * @description:
 * @author: dongxiazi
 * @create: 2020/12/25 15:22
 */
@Service
public interface IResourceService {
    //动态新增更新权限
    void saveResource(Resource resource);

    //动态删除权限
    void removeResource(Resource resource);

    //加载权限资源数据
    void loadResource();

    //根据url和method查询到对应的权限信息
    ConfigAttribute findConfigAttributesByUrl(HttpServletRequest authRequest);

    //根据用户名查询 该用户所拥有的角色对应的资源信息
    Set<Resource> queryByUsername(String username);
}
