package com.plig.realm;

import java.util.Set;

import com.plig.dao.AuthorityDao;
import com.plig.dao.UserDao;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.plig.dao.AuthorityDao;
import com.plig.dao.UserDao;
import com.plig.entity.User;

public class MyRealm extends AuthorizingRealm {
    @Autowired
    private UserDao userDao;
    @Autowired
    private AuthorityDao authorityDao;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // TODO Auto-generated method stub
        // 获取用户
        String no = (String) principals.getPrimaryPrincipal();
        // 从数据库中获取用户角色和权限表

        Set<String> roleSet = authorityDao.findRoleByNo(no);
        Set<String> permitSet = authorityDao.findPermitByNo(no);
        // 授权信息的对象
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 设置用户对应的角色
        info.setRoles(roleSet);
        // 设置对应的权限
        info.setStringPermissions(permitSet);

        return info;

    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // TODO Auto-generated method stub
        //获取token中的用户名
        String no = (String) token.getPrincipal();
        //从数据库中根据用户名获取密码信息
        User user = userDao.findUserByNo(no);
        if (user == null) {
            throw new UnknownAccountException();
        }
        String password = user.getPassword();
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(no, password, this.getName());
        return info;
    }

}
