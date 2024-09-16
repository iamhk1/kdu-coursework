package org.example.dto;

import lombok.Data;
import org.example.entity.Product;
@Data
public class InventoryDTO {
    private Long id;
    private String name;
    private Product product;
}
