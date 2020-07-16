package com.jlyk.service;

public interface CarUserService {
    public void insertCarUser(Integer uid,Integer cid);


    public  void deleteCarUser(Integer cid, Integer uid);


    public Integer findIdByUidAndCid(int cid,int uid);


    public Integer findIdByCid(Integer cid);
}
