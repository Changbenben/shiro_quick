package com.baizhi.springboot_jsp_shiro.dao;

import com.baizhi.springboot_jsp_shiro.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    void save(User user);
    User findUserbyUsername(String username);
}
