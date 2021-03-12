package com.baizhi.springboot_jsp_shiro.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 工厂 = ApplicaitonContext
 * 提供非工厂中的类 获取工厂中的 Bean 的方法
 */
@Component
public class ApplicationContextUtils implements ApplicationContextAware {

    private static ApplicationContext context;

    /**
     * 调用这个方法时，springboot会将ApplicationContext作为参数传入，
     * 将ApplicaitonContext保存到 私有成员
     * 再提供get方法 即可获取ApplicationContext中的Bean
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    /**
     * 返回工厂中指定名字的Bean
     * @param beanName
     * @return
     */
    public static Object getApplicationContext(String beanName){
        return context.getBean(beanName);
    }

}
