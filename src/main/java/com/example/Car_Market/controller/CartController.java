package com.example.Car_Market.controller;


import com.example.Car_Market.model.Car;
import com.example.Car_Market.model.Cart;
import com.example.Car_Market.service.CartServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {

   private final CartServiceImpl cartService;

   @PostMapping("{id}")
    public Cart createCart(@PathVariable String id){
       return cartService.create(id);
       //Long newId= Long.valueOf(id);

   }
   @GetMapping
    public List<Cart> getCart(){
       return cartService.getCart();
   }
   @DeleteMapping("/delete/{id}")
    public void deleteCar(@PathVariable Long id){
       cartService.deleteCar(id);
   }
   @PutMapping("/buy")
    public List<Car> addCar(@RequestBody Car car){
       return cartService.addCar(car);
   }

}
