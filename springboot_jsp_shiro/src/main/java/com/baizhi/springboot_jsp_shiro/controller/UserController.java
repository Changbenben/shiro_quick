package com.baizhi.springboot_jsp_shiro.controller;

import com.baizhi.springboot_jsp_shiro.entity.User;
import com.baizhi.springboot_jsp_shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 登出
     * @return
     */
    @RequestMapping("logout")
    public String logout(){
        SecurityUtils.getSubject().logout();
        return "redirect:/login.jsp";
    }


    /**
     * 登录 跳转到index
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("login")
    public String login(String username, String password){
        //通过安全工具获得主体，无需注入安全管理类，springboot自动取出工厂中的 进行注入
        Subject subject = SecurityUtils.getSubject();

        //获得token
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        //登录
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            System.out.println("用户名错误");
        } catch (IncorrectCredentialsException e){
            e.printStackTrace();
            System.out.println("密码错误");
        }
        return "redirect:/index.jsp";
    }

    @RequestMapping("regist")
    public String save(User user){
        try {
            userService.save(user);
            return "redirect:/login.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/regist.jsp";
        }


    }
}
