package com.kdu.smartHome.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class House {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String address;
    private String houseName;
    private String adminUsername;
    @ManyToMany
    List<User> usersList=new ArrayList<>();
    @OneToMany
    List<Rooms>roomsList=new ArrayList<>();
}
