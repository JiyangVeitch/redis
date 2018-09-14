package com.veitch.redis.service.impl;

import com.veitch.redis.mapper.UserMapper;
import com.veitch.redis.pojo.User;
import com.veitch.redis.pojo.UserExample;
import com.veitch.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Cacheable("login")
    @Override
    public User login(User user) {
        return userMapper.login(user);
    }

    @CacheEvict(value = {"login", "selectAll", "selectById"}, allEntries = true)
    @Override
    public int insertUser(User user) {
        return userMapper.insert(user);
    }

    @Cacheable("selectAll")
    @Override
    public List<User> selectAll() {
        UserExample example = new UserExample();
        example.setOrderByClause("id asc");
        return userMapper.selectByExample(example);
    }

    @CacheEvict(value = {"login", "selectAll", "selectById"}, allEntries = true)
    @Override
    public int deleteById(int id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Cacheable("selectById")
    @Override
    public User selectById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @CacheEvict(value = {"login", "selectAll", "selectById"}, allEntries = true)
    @Override
    public int updateUser(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }
}
