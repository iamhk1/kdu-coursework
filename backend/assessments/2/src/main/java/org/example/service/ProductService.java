package org.example.service;

import org.example.dao.ProductRepository;
import org.example.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository)
    {
        this.productRepository=productRepository;
    }
    public void addProduct(Product product)
    {
        productRepository.save(product);
    }
}
