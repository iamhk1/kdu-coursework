package org.example.service;

import org.example.dao.CartRepository;
import org.example.entity.Cart;
import org.example.exceptions.customexception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    CartRepository cartRepository;
    UsersService userService;
    @Autowired
    public CartService(CartRepository cartRepository,UsersService userService)
    {
        this.userService=userService;
        this.cartRepository=cartRepository;
    }
    public void addToCart(Cart cart)
    {
        cartRepository.save(cart);
    }
    public List<Cart> getCart()
    {
        return cartRepository.getCart();
    }
    public void deleteCart(Long id)
    {

        if(cartRepository.existsById(id)) {
            cartRepository.deleteById(id);
        }
        else
            throw new CustomException("Cannot delete because id not found");
    }
    public void updateCart(Long id,String name)
    {
        if(cartRepository.existsById(id)) {
            cartRepository.updateCart(id,name);
        }
        else
            throw new CustomException("Cannot delete because id not found");
    }
}
