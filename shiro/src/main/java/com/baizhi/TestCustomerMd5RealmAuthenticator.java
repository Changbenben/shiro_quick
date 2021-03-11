package com.baizhi;

import com.baizhi.realm.CustomerMd5Realm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;

import java.util.Arrays;

public class TestCustomerMd5RealmAuthenticator {
    public static void main(String[] args) {
        //创建安全管理器
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        //创建realm
        CustomerMd5Realm customerMd5Realm = new CustomerMd5Realm();

        //设置realm使用hash凭证匹配器
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        //使用算法
        credentialsMatcher.setHashAlgorithmName("md5");
        //散列次数
        credentialsMatcher.setHashIterations(1024);
        //将hash凭证匹配器注入realm
        customerMd5Realm.setCredentialsMatcher(credentialsMatcher);

        //将realm注入安全管理器
        defaultSecurityManager.setRealm(customerMd5Realm);

        //将安全管理器注入安全工具
        SecurityUtils.setSecurityManager(defaultSecurityManager);

        //获取Subject
        Subject subject = SecurityUtils.getSubject();

        //认证
        UsernamePasswordToken token = new UsernamePasswordToken("xiaochen", "123");

        try {
            subject.login(token);
            System.out.println("Login Success");
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            System.out.println("Unknown Username");
        } catch (IncorrectCredentialsException e){
            e.printStackTrace();
            System.out.println("Incorrect Password");
        }

        if (subject.isAuthenticated()){
            //基于角色权限控制
            boolean[] booleans = subject.hasRoles(Arrays.asList("admin", "user"));
            for (boolean b : booleans) {
                System.out.println(b);
            }
            //基于权限字符串的访问控制
            boolean[] permitted = subject.isPermitted("user:*:01", "product:create:02");
            for(boolean b : permitted){
                System.out.println(b);
            }

        }
    }
}
