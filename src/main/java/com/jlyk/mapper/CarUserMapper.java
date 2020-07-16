package com.jlyk.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CarUserMapper {
    @Insert("insert into car_user(cid,uid) values(#{cid},#{uid})")
    void insertCarUser(Integer uid,Integer cid);

    @Delete("delete from car_user where cid = #{cid} and uid = #{uid}")
     void deleteCarUser(Integer cid, Integer uid);

    @Select("select car_user.cuid  from car_user where cid = #{cid} and uid = #{uid}")
     Integer findIdByUidAndCid(int cid,int uid);

    @Select("select cid from car_user where cid = #{cid}")
     Integer findIdByCid(Integer cid);
}
