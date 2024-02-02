package org.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="cart")
@Data
public class Cart {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column
    @JsonProperty("product")
    private String product;

    @Column
    @JsonProperty("quantity")
    private String quantity;

//    @OneToOne
//    private Users user;


}
