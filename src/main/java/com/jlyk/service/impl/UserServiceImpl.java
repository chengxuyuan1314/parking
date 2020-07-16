package com.jlyk.service.impl;

import com.jlyk.domain.User;
import com.jlyk.mapper.UserMapper;
import com.jlyk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return userMapper.findByUsernameAndPassword(username,password);
    }

    @Override
    public User findByID(int uid) {
        return userMapper.findByID(uid);
    }

    @Override
    public User findByCid(int cid) {
        return userMapper.findByCid(cid);
    }

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public void updateMoneyByID(int uid, int money) {
        userMapper.updateMoneyByID(uid, money);
    }

    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public int findIdByUsername(String username) {
        return userMapper.findIdByUsername(username);
    }

    @Override
    public int findMoneyByID(int uid) {
        return userMapper.findMoneyByID(uid);
    }

    @Override
    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }

    @Override
    public void updateUserByUsername(User user) {
        userMapper.updateUserByUsername(user);
    }
}
