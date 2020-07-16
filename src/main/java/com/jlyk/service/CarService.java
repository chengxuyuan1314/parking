package com.jlyk.service;

import com.jlyk.domain.Car;

import java.util.List;

public interface CarService {
    public List<Car> findByUID(Integer uid);


    public List<Car> findByInParking();

    public List<Car> findAllCar();

    public void insertCar(String license,String carName);

    public Car findByLicense(String license);

    public void deleteCar(Integer cid);

    public Car findByCid(Integer cid);

    public void updateCar(Car car);
}
