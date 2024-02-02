package org.example.service;

import org.example.dao.InventoryRepository;
import org.example.dto.InventoryDTO;
import org.example.entity.Inventory;
import org.example.exceptions.customexception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {
    InventoryRepository inventoryRepository;
    @Autowired
    public InventoryService(InventoryRepository inventoryRepository)
    {
        this.inventoryRepository=inventoryRepository;
    }
    public void addInventory(InventoryDTO inventory)
    {
        Inventory newInventory=new Inventory();
        newInventory.setId(inventory.getId());
        newInventory.setName(inventory.getName());
        newInventory.setProduct(inventory.getProduct());
        inventoryRepository.save(newInventory);
    }
    public void delete(Long id)
    {
        if(inventoryRepository.existsById(id)) {
            inventoryRepository.deleteById(id);
        }
        else
            throw new CustomException("This id does not exist");
    }
    public void updateInventory(Long id,String name)
    {
        if(inventoryRepository.existsById(id)) {
            inventoryRepository.updateInventory(id, name);
        }
        else
            throw new CustomException("Cannot Update Because Id not found");
    }
}
