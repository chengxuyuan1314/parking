package com.jlyk.mapper;

import com.jlyk.domain.Car;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CarMapper {

    List<Car> findByUID(Integer uid);

    @Select("select * from car where inparking > 0")
     List<Car> findByInParking();
    @Select("select * from car ")
    List<Car> findAllCar();
    @Insert("insert into car(license,carName) values(#{license},#{carName})")
    void insertCar(String license,String carName);
    @Select("select * from car where license = #{license}")
    Car findByLicense(String license);
    @Delete("delete from car where cid = #{cid}")
    void deleteCar(Integer cid);
    @Select("select * from car where cid = #{cid}")
    Car findByCid(Integer cid);
    @Update("update car set license = #{license},carName=#{carName} where cid=#{cid}")
    void updateCar(Car car);
}
