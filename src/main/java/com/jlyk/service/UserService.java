package com.jlyk.service;

import com.jlyk.domain.User;

import java.util.List;

public interface UserService {
    public User findByUsernameAndPassword(String username,String password);
    public User findByID(int uid);
    public User findByCid(int cid);
    public User findByUsername(String username);
    public void updateMoneyByID(int uid,int money);
    public void insertUser(User user);
    public int findIdByUsername(String username);
    public int findMoneyByID(int uid);
    public List<User> findAllUser();
    public void updateUserByUsername(User user);
}
