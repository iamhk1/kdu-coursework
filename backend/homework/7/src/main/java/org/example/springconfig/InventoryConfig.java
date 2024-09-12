package org.example.springconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages ="org.example.inventory")
public class InventoryConfig {
    @Bean()
    @Scope("prototype")
    org.example.inventory.InventoryStore inventoryStore1()
    {
        return new org.example.inventory.InventoryStore();

    }

}
