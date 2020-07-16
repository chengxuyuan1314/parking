package com.jlyk.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthorityMapper {

    @Insert("insert into user_authority(uid) values(#{uid})")
    public void insertAuthority(Integer uid);


}
