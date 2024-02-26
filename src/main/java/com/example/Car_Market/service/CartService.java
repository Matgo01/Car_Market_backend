package com.example.Car_Market.service;

import com.example.Car_Market.model.Car;
import com.example.Car_Market.model.Cart;
import com.example.Car_Market.model.User;

import java.util.List;

public interface CartService {

    Cart create(String id);

    void deleteCar(Long id);

    List<Cart> getCart();

    List<Car> addCar(Car car);


}
