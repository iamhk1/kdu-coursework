package com.kdu.smartHome.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rooms {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String roomName;
    @OneToMany
    List<Inventory> inventoryList=new ArrayList<>();
}
