package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;



@Data
@Entity
@Table(name="tenant")
public class Tenant {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "CHAR(36) DEFAULT (UUID())")
    private String id;

    private String name;


    @Embedded
    private Base base;
}
