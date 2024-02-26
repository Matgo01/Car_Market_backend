package com.example.Car_Market.controller;

import com.example.Car_Market.model.Car;
import com.example.Car_Market.service.CarServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequiredArgsConstructor
@RequestMapping("/car")
public class CarController {
    private final CarServiceImpl carService;

    @PostMapping
    public Car createCar(@RequestBody Car car){
        return carService.addCar(car);
    }
    @GetMapping
    public List<Car> getAllCar(){
        return carService.getCar();
    }
    @GetMapping("/{id}")
    public Car getCarById(Integer id){
        return carService.getCarById(id);
    }
    @PutMapping("/update/{id}")
    public Car updateCar(@RequestBody Car car,@PathVariable Integer id){
        return carService.updateCar(car,id);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteCar(@PathVariable Integer id){
        carService.deleteCar(id);
    }

}
