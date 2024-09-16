package org.example.controller;

import org.example.entity.Inventory;
import org.example.entity.Product;
import org.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    ProductService productService;
    @Autowired
    public  ProductController(ProductService productService)
    {
        this.productService=productService;
    }
    @PostMapping("/product")
    public ResponseEntity<String> addUser(@RequestBody Product product)
    {

        productService.addProduct(product);
        return ResponseEntity.ok("Product added successfully");
    }

}
