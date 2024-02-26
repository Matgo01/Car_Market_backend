package com.example.Car_Market.service;


import com.example.Car_Market.model.User;
import com.example.Car_Market.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public User RegisterUser(User usr) {
        return userRepository.save(usr);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> updateUser(User user, String email) {
        User thisUser=userRepository.findByEmail(email);
        Long id=thisUser.getId();
        return userRepository.findById(id).map(user1->{
            user1.setFirstName(user.getFirstName());
            user1.setLastName(user.getLastName());
            user1.setEmail(user.getEmail());
            user1.setUsername(user.getUsername());
            user1.setPassword(user.getPassword());
            return userRepository.save(user1);
        });
    }

    @Override
    public void deleteUser(String email) {
       User user= userRepository.findByEmail(email);
       Long id=user.getId();
       userRepository.deleteById(id);

    }

    @Override
    public Long Login(String email, String password){
        User user=userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(user.getPassword())) {
            // Restituisci l'ID dell'utente
            return user.getId();
        } else {
            // Se l'utente non esiste o la password non corrisponde, restituisci null o un valore di errore
            return null;
        }
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return Optional.ofNullable(userRepository.findByEmail(email));
    }
}
