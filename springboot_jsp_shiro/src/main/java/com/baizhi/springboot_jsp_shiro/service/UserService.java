package com.baizhi.springboot_jsp_shiro.service;

import com.baizhi.springboot_jsp_shiro.entity.User;
import org.springframework.stereotype.Service;

public interface UserService {
    void save(User user);
    User findUserByUsername(String username);
}
