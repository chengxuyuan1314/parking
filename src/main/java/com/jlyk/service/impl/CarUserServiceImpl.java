package com.jlyk.service.impl;

import com.jlyk.mapper.CarUserMapper;
import com.jlyk.service.CarUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarUserServiceImpl implements CarUserService {

    @Autowired
    private CarUserMapper carUserMapper;
    @Override
    public void insertCarUser(Integer uid, Integer cid) {
        carUserMapper.insertCarUser(uid,cid);
    }

    @Override
    public void deleteCarUser(Integer cid, Integer uid) {
        carUserMapper.deleteCarUser(cid,uid);
    }

    @Override
    public Integer findIdByUidAndCid(int cid, int uid) {
        return carUserMapper.findIdByUidAndCid(cid, uid);
    }

    @Override
    public Integer findIdByCid(Integer cid) {
        return carUserMapper.findIdByCid(cid);
    }
}
