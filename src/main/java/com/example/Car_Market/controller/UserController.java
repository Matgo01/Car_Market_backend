package com.example.Car_Market.controller;

import com.example.Car_Market.model.User;
import com.example.Car_Market.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserServiceImpl userService;

    @PostMapping("/register")
    public User register(@RequestBody User user){
        return userService.RegisterUser(user);
    }

    /*@PostMapping("/login")
    public boolean login(@RequestBody User user){
        String email=user.getEmail();
        String password= user.getPassword();
        return userService.Login(email,password);
    }*/

    @PostMapping("login")
    public Long loginUser(@RequestBody User user){
        String email= user.getEmail();
        String password= user.getPassword();
        return userService.Login(email,password);
    }

    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable String id){
        return userService.getUserByEmail(id);
    }

    @PutMapping("/update/{email}")
    public Optional<User> updateUser(@RequestBody User user, @PathVariable String email){
        return userService.updateUser(user,email);
    }
    @DeleteMapping("/delete/{email}")
    public void deleteUser(@PathVariable String email){
        userService.deleteUser(email);
    }

}
