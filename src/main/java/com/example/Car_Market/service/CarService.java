package com.example.Car_Market.service;

import com.example.Car_Market.model.Car;

import java.util.List;

public interface CarService {

    Car addCar(Car car);

    List<Car> getCar();

    Car updateCar(Car car, Integer id);

    Car getCarById(Integer id);

    List<Car> getCarByProductionYear(Integer year);

    void deleteCar(Integer id);
}
