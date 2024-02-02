package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="address")
public class Address {

    @Id
    @Column(name="nickname")
    private String nickname;

    @Column
    private String street;
    @Column
    private String state;
    @Column(name="postal_code")
    private String postalCode;

//    @ManyToOne
//    private Users user;
}
