package com.zy.shirozy.shiro;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/10/12 16:16
 * 为Shiro提供数据源主要包括：1、认证 登录许可  2、当前用户的对应权限或角色
 */
@Service
public class UserRealm extends AuthorizingRealm {
//    @Autowired
//    private PermissionService permissionService;
    //权限或者角色
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登录用户
//        User user=(User)SecurityUtils.getSubject().getSession().getAttribute("user");
//        //查询当前用户的权限
//        List<String> pers=permissionService.queryByUid(user.getId());
//        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
//        info.addStringPermissions(pers);
        return null;
    }

    //认证   登录校验
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token=(UsernamePasswordToken)authenticationToken;
        System.out.println(token.getUsername());
        if(token.getUsername()!=null && token.getUsername().length()>0){
            return new SimpleAuthenticationInfo(token.getUsername(),token.getPassword(),getName());
        }
        return null;
    }
}
