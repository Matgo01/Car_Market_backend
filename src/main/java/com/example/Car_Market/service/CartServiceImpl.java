package com.example.Car_Market.service;

import com.example.Car_Market.exception.CartNotFoundException;
import com.example.Car_Market.exception.UserNotFoudException;
import com.example.Car_Market.model.Car;
import com.example.Car_Market.model.Cart;
import com.example.Car_Market.model.User;
import com.example.Car_Market.repository.CartRepository;
import com.example.Car_Market.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    private final UserRepository userRepository;

    @Override
    public Cart create(String id) {
        User user=userRepository.findByEmail(id);
        Cart cart = new Cart(); // Crea un nuovo oggetto Cart
        cart.setUser(user);
        return cartRepository.save(cart);
    }

    @Override
    public void deleteCar(Long id) {
        if (!cartRepository.existsById(id)) {
            throw new CartNotFoundException("Sorry, cart not found");
        } else {
            cartRepository.deleteById(id);
        }
    }

    @Override
    public List<Cart> getCart() {
        return cartRepository.findAll();
    }

    @Override
    public List<Car> addCar(Car car) {
        Cart cart = new Cart(); // Crea un nuovo oggetto Cart
        cart.setCar(List.of(car)); // Imposta la lista di auto sul nuovo oggetto Cart
        cartRepository.save(cart); // Salva il nuovo oggetto Cart nel repository
        return cart.getCar();
    }
}
