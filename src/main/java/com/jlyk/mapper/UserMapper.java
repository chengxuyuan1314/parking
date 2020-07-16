package com.jlyk.mapper;

import com.jlyk.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {


    User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
    User findByID(int uid);
    User findByCid(int cid);
    User findByUsername(String username);
    @Update("update user set money = #{money} where uid = #{uid}")
    void updateMoneyByID(int uid,int money);
    @Insert("insert into user(username,password,tel,name) values(#{username},#{password},#{tel},#{name})")
    void insertUser(User user);
    @Select("select user.uid from user where username=#{username}")

    int findIdByUsername(String username);
    @Select("select user.money from user where uid= #{uid}")
    int findMoneyByID(int uid);
    @Select("select * from user")
    List<User> findAllUser();

    @Update("update user set name = #{name},tel =#{tel} where username = #{username}")
    void updateUserByUsername(User user);





}
