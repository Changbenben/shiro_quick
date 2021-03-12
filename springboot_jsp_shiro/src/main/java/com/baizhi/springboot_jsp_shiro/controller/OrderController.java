package com.baizhi.springboot_jsp_shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("order")
public class OrderController {
    /**
     * 判断 当前角色 有无权限
     * 登录后访问其他controller，依然保持角色及权限
     * 代码演示
     * @return
     */
    @RequestMapping("save")
    public String save(){
        Subject subject = SecurityUtils.getSubject();
        if (subject.hasRole("user")){
            System.out.println("保存订单！");
        }else{
            System.out.println("无权访问！");
        }
        return "redirect:/index.jsp";
    }


    /**
     * 注解形式判断角色
     * @return
     */
    @RequestMapping("save1")
    @RequiresRoles(value={"admin","user"})  //需要同时具有admin、user角色
    public String save1(){
        System.out.println("注解形式判断角色");
        return "redirect:/index.jsp";
    }
}
