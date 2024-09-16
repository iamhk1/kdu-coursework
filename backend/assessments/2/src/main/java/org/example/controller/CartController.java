package org.example.controller;

import org.example.entity.Cart;
import org.example.entity.Users;
import org.example.service.CartService;
import org.example.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {
    CartService cartService;
    @Autowired
    public CartController(CartService cartService)
    {
        this.cartService=cartService;
    }

    /**
     *
     * @param cart add new item to cart
     */
    @PostMapping("/cart/add")
    public ResponseEntity<String> addToCart(@RequestBody Cart cart)
    {

        cartService.addToCart(cart);
        return ResponseEntity.ok("Item  added to Cart successfully");
    }

    /**
     *
     * @return All the items present in cart
     */
    @GetMapping("/cart/get")
    public List<Cart> getCart()
    {
        return cartService.getCart();
    }

    /**
     *
     * @param id get the product id
     * @return message of success or failure
     */
    @DeleteMapping("/cart/{id}")
    public ResponseEntity<String>deleteCart(@PathVariable Long id)
    {

        cartService.deleteCart(id);
        return ResponseEntity.ok("Deleted Successfully");
    }
    @PutMapping("/cart")
    public ResponseEntity<String>updateInventory(@RequestParam Long id,@RequestParam String name)
    {
        cartService.updateCart(id,name);
        return ResponseEntity.ok("Cart Updated");
    }

}
