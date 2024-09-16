package org.example.controller;

import org.example.dto.InventoryDTO;
import org.example.entity.Inventory;
import org.example.entity.Users;
import org.example.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class InventoryController {
    InventoryService inventoryService;
    @Autowired
    public InventoryController(InventoryService inventoryService)
    {
        this.inventoryService=inventoryService;
    }

    /**
     *
     * @param inventory to add new value to inventory
     */
    @PostMapping("/inventory")
    public void addUser(@RequestBody InventoryDTO inventory)
    {
        inventoryService.addInventory(inventory);
    }

    /**
     *
     * @param id get id and delete the record from inventory
     * @return success or failure message
     */
    @DeleteMapping("/inventory/{id}")
    public ResponseEntity<String>deleteInventory(@PathVariable Long id)
    {
        inventoryService.delete(id);
        return ResponseEntity.ok("ok");
    }

    /**
     *
     * @param id get id to update based on it
     * @param name field to be updated
     * @return success or failure message
     */
    @PutMapping("/inventory")
    public ResponseEntity<String>updateInventory(@RequestParam Long id,@RequestParam String name)
    {
        inventoryService.updateInventory(id,name);
        return ResponseEntity.ok("Updated");
    }
}
