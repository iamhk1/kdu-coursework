package org.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="inventory")
@Data
public class Inventory {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JsonProperty("product")
    private Product product;
    @Column(name="name")
    @JsonProperty("name")
    private String name;
}
