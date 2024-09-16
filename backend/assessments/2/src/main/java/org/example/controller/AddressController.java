package org.example.controller;

import org.example.entity.Address;
import org.example.entity.Cart;
import org.example.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller For Address
 */
@RestController
public class AddressController {
    AddressService addressService;
    @Autowired
    public AddressController(AddressService addressService)
    {
        this.addressService=addressService;
    }

    /**
     *
     * @param address adding new address
     */
    @PostMapping("/address")
    public ResponseEntity<String> addToCart(@RequestBody Address address)

    {
        addressService.addAddress(address);
        return ResponseEntity.ok("Address added Successfully");
    }
}
