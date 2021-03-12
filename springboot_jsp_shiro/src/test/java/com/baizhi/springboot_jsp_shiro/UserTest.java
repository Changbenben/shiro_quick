package com.baizhi.springboot_jsp_shiro;

import com.baizhi.springboot_jsp_shiro.dao.UserDao;
import com.baizhi.springboot_jsp_shiro.entity.User;
import com.baizhi.springboot_jsp_shiro.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;


@SpringBootTest(classes = SpringbootJspShiroApplication.class)
@RunWith(SpringRunner.class)
public class UserTest {
    @Autowired
    UserDao userDao;
    @Autowired
    UserService userService;

    @Test
    public void saveTest(){
        User user = new User();
        user.setUsername("test");
        user.setPassword("test");

        userDao.save(user);
    }

    @Test
    public void service_save(){
        User user = new User();
        user.setUsername("test");
        user.setPassword("test");
        userService.save(user);
    }

    @Test
    public void findByNameTest(){
        System.out.println(userDao.findByUsername("zhangsan"));
    }
}
