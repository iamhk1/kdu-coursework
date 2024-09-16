package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name="price")
    private int price;
    @Column(name="quantity")
    private int quantity;


}
