package org.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name="users")
public class Users {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name="email")
    private String email;
    @OneToMany
    @JsonProperty("address")
    private List<Address> address;
    @OneToMany
    @JsonProperty("cart")
    private List<Cart> cart;


}
