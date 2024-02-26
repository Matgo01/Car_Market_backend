package com.example.Car_Market.service;

import com.example.Car_Market.exception.CarNotFoundException;
import com.example.Car_Market.model.Car;
import com.example.Car_Market.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService{

    private final CarRepository carRepository;


    @Override
    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public List<Car> getCar() {
        return carRepository.findAll();
    }

    @Override
    public Car updateCar(Car car, Integer id) {
        return carRepository.findById(id).map(car1->{
            car1.setBrand(car.getBrand());
            car1.setProductionYear(car.getProductionYear());
            car1.setPrice(car.getPrice());
            car1.setImageUrl(car.getImageUrl());
            return carRepository.save(car1);
        }).orElseThrow(()->new CarNotFoundException("car not found"));
    }

    @Override
    public Car getCarById(Integer id) {
        return carRepository.findById(id).orElseThrow(()->new CarNotFoundException("car not found"));
    }



    @Override
    public List<Car> getCarByProductionYear(Integer year) {
        return carRepository.findByProductionYear(year);
    }

    @Override
    public void deleteCar(Integer id) {
        if(!carRepository.existsById(id)){
            throw new CarNotFoundException("sorry, car not found");
        }else{
            carRepository.deleteById(id);
        }

    }
}
