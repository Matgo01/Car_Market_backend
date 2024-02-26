package com.example.Car_Market.repository;

import com.example.Car_Market.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Integer>{
    List<Car> findByProductionYear(Integer year);
}
