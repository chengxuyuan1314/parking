package com.jlyk.service.impl;

import com.jlyk.mapper.AuthorityMapper;
import com.jlyk.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorityServiceImpl implements AuthorityService {
    @Autowired
    private AuthorityMapper authorityMapper;
    @Override
    public void insertAuthority(Integer uid) {
        authorityMapper.insertAuthority(uid);
    }
}
