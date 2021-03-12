package com.baizhi.springboot_jsp_shiro.config;
/*
* 用来整合shiro框架相关的配置类
* */

import com.baizhi.springboot_jsp_shiro.shiro.CustomerRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    /**
     * 1.创建shiroFilter
     *   负责拦截所有请求
     *   @param defaultWebSecurityManager
     *   自动在工厂中寻找注册过的DefaultWebSecurityManager
     *   @return
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //给filter设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

        //配置系统受限资源
        Map<String, String> map = new HashMap<>();
        map.put("/index.jsp", "authc");      //authc 请求这个资源需要认证和授权
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);

        //默认认证界面路径
        shiroFilterFactoryBean.setLoginUrl("/login.jsp");

        //配置系统公共资源

        return shiroFilterFactoryBean;
    }

    /**
     * 2.创建SecurityManager
     *   @param realm
     *   @return
     */
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("getRealm") Realm realm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(realm);
        return defaultWebSecurityManager;
    }

    /**
     * 3.创建Realm
     *   @return
     */
    @Bean
    public Realm getRealm(){
        CustomerRealm customerRealm = new CustomerRealm();
        return customerRealm;
    }
}
