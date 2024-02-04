package com.kdu.smartHome.controllers;

import com.kdu.smartHome.dto.AddDeviceDTO;
import com.kdu.smartHome.dto.InventoryRequestDTO;
import com.kdu.smartHome.dto.InventoryResponseDTO;

import com.kdu.smartHome.service.InventoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
public class InventoryController {
    private InventoryService inventoryService;
    public InventoryController(InventoryService inventoryService)
    {
        this.inventoryService=inventoryService;
    }

    @GetMapping("/inventory")
    public ResponseEntity<InventoryResponseDTO> getAllInventory()
    {

        InventoryResponseDTO inventoryResponse= inventoryService.getAllInventory();
        return ResponseEntity.ok(inventoryResponse);
    }
    @PostMapping("/inventory")
    public ResponseEntity<String> addItem(@RequestBody InventoryRequestDTO inventoryRequestDTO)
    {
            inventoryService.addItem(inventoryRequestDTO);
            return ResponseEntity.ok("Item added");
    }
    @PostMapping("/device/register")
    public ResponseEntity<String>registerDevice(@RequestBody InventoryRequestDTO inventoryRequestDTO)
    {
        inventoryService.register(inventoryRequestDTO);
        return ResponseEntity.ok("Added");
    }
    @PostMapping("/device/add")
    public ResponseEntity<String>addDeviceToHouse(@RequestBody AddDeviceDTO deviceDto)
    {
        inventoryService.addDeviceToHome(deviceDto);
        return ResponseEntity.ok("Added to room");
    }

}
