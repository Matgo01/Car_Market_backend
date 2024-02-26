package com.example.Car_Market.repository;

import com.example.Car_Market.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {
}
