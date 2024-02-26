package com.example.Car_Market.repository;

import com.example.Car_Market.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
   User findByEmail(String email);
}
