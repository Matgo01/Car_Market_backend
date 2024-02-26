package com.example.Car_Market.service;

import com.example.Car_Market.model.User;

import java.util.Optional;

public interface UserService {

    User RegisterUser(User usr);

    Optional<User> getUserById(Long id);

    Optional<User> updateUser(User user, String email);

    void deleteUser(String email);

    Long Login(String username, String password );

    Optional<User> getUserByEmail(String email);
}
