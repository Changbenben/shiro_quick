package com.baizhi.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

public class CustomerMd5Realm extends AuthorizingRealm {
    //授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String principal = (String) principalCollection.getPrimaryPrincipal();

        //根据用户身份信息 用户名 获取当前用户角色信息 权限信息
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        //将数据库中查询到的角色信息负权给权限对象
        simpleAuthorizationInfo.addRole("admin");
        simpleAuthorizationInfo.addRole("user");

        //将数据库中查询到的权限信息赋权给权限对象
        simpleAuthorizationInfo.addStringPermission("user:*:01");
        simpleAuthorizationInfo.addStringPermission("product:create");

        return simpleAuthorizationInfo;
    }

    //认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String principal = (String) authenticationToken.getPrincipal();
        //认证成功，返回数据库中正确的info
        if ("xiaochen".equals(principal)){
            return new SimpleAuthenticationInfo(
                    //参数1: 数据库用户名  参数2:数据库md5+salt之后的密码  参数3:注册时的随机盐  参数4:realm的名字
                    principal,
                    "e4f9bf3e0c58f045e62c23c533fcf633",
                    ByteSource.Util.bytes("X0*7ps"),
                    this.getName()
            );
        }
        return null;
    }
}
