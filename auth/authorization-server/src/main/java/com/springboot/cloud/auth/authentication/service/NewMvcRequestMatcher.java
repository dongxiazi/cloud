package com.springboot.cloud.auth.authentication.service;

import lombok.Getter;
import org.springframework.http.HttpMethod;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

/**
 * @description:
 * @author: dongxiazi
 * @create: 2020/12/25 15:31
 */
@Getter
public class NewMvcRequestMatcher extends MvcRequestMatcher {
    private String pattern;
    private String method;

    public NewMvcRequestMatcher(HandlerMappingIntrospector introspector, String pattern) {
        super(introspector, pattern);
        this.setMethod(HttpMethod.resolve(method));

    }
}
