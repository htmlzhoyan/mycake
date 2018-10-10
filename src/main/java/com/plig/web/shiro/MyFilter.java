package com.plig.web.shiro;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class MyFilter extends AuthorizationFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object mappers) throws Exception {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        if (request.getRequestURI().contains(".do")){
            return true;
        }
        // 获取主体
        Subject subject = getSubject(servletRequest,servletResponse);
        // 获取需要校验的角色
        String[] checkRoles = (String[])mappers;
        System.out.println("角色："+checkRoles);
        // 逐一校验
        for (String s:checkRoles) {
            if (subject.hasRole(s)){
                return true;
            }
        }
        return false;
    }
}
