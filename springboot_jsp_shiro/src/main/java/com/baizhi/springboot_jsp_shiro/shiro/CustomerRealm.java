package com.baizhi.springboot_jsp_shiro.shiro;

import com.baizhi.springboot_jsp_shiro.entity.User;
import com.baizhi.springboot_jsp_shiro.service.UserService;
import com.baizhi.springboot_jsp_shiro.utils.ApplicationContextUtils;
import com.sun.corba.se.spi.orbutil.fsm.FSMImpl;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.util.ObjectUtils;

public class CustomerRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String primaryPrincipal = (String) principalCollection.getPrimaryPrincipal();

        if (primaryPrincipal.equals("zhangsan")){
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            //添加“用户”权限
            simpleAuthorizationInfo.addRole("user");
            //添加资源权限
            simpleAuthorizationInfo.addStringPermission("user:find:*");
            simpleAuthorizationInfo.addStringPermission("user:delete:*");
            return simpleAuthorizationInfo;
        }
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取身份信息
        String principal = (String) token.getPrincipal();
        //在工厂中获取service对象
        UserService userService = (UserService) ApplicationContextUtils.getApplicationContext("userService");

        User user = userService.findByUsername(principal);
        if (!ObjectUtils.isEmpty(user)){
            // ctrl+P 可以看参数提醒
            return new SimpleAuthenticationInfo(
                    user.getUsername(),
                    user.getPassword(),
                    ByteSource.Util.bytes(user.getSalt()),  //String转ByteSource
                    this.getName());
        }
        return null;
    }
}
