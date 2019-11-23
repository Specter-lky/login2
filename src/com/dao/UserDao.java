package com.dao;

import com.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository("userDao")
@Mapper
public interface UserDao {
    public int addUser(User user);
    public User login(User user);
    public User check(String username);
}
