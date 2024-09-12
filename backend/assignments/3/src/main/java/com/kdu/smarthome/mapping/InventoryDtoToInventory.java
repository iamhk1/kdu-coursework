package com.kdu.smartHome.mapping;

import com.kdu.smartHome.dto.InventoryRequestDTO;
import com.kdu.smartHome.model.Inventory;

public class InventoryDtoToInventory {
    public static Inventory inventoryDtoToInventory(InventoryRequestDTO inventoryDto)
    {
        Inventory inventory=new Inventory();
        inventory.setKickstonId(inventoryDto.getKickstonId());
        inventory.setUsername(inventoryDto.getUsername());
        inventory.setPassword(inventoryDto.getPassword());
        inventory.setVerified(false);
        inventory.setManufacturePlace(inventoryDto.getManufacturePlace());
        inventory.setManufactureDateTime(inventoryDto.getManufactureDateTime());
        return inventory;
    }
}
