package com.veitch.redis.service;

import com.veitch.redis.pojo.User;

import java.util.List;

public interface UserService {

    User login(User user);

    int insertUser(User user);

    List<User> selectAll();

    int deleteById(int id);

    User selectById(int id);

    int updateUser(User user);
}
