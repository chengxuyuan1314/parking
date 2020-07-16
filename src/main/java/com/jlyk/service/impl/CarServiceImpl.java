package com.jlyk.service.impl;

import com.jlyk.domain.Car;
import com.jlyk.mapper.CarMapper;
import com.jlyk.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarMapper carMapper;
    @Override
    public List<Car> findByUID(Integer uid) {
        return carMapper.findByUID(uid);
    }

    @Override
    public List<Car> findByInParking() {
        return carMapper.findByInParking();
    }

    @Override
    public List<Car> findAllCar() {
        return carMapper.findAllCar();
    }

    @Override
    public void insertCar(String license, String carName) {
        carMapper.insertCar(license,carName);
    }

    @Override
    public Car findByLicense(String license) {
        return carMapper.findByLicense(license);
    }

    @Override
    public void deleteCar(Integer cid) {
        carMapper.deleteCar(cid);
    }

    @Override
    public Car findByCid(Integer cid) {
        return carMapper.findByCid(cid);
    }

    @Override
    public void updateCar(Car car) {
        carMapper.updateCar(car);
    }
}
