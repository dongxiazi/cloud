package com.springboot.cloud.auth.authentication.service;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @description:
 * @author: dongxiazi
 * @create: 2020/12/25 15:29
 */
@Service
public interface IAuthenticationService {
    /**
     * 校验权限
     * @param authRequest
     * @return 是否有权限
     */
    boolean decide(HttpServletRequest authRequest);
}
