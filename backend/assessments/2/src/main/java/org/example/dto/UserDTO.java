package org.example.dto;

import lombok.Data;
import org.example.entity.Address;
import org.example.entity.Cart;

import java.util.List;
@Data
public class UserDTO {
    private Long id;
    String name;
    private String email;
    private List<Address> address;
    private List<Cart> cart;

}
