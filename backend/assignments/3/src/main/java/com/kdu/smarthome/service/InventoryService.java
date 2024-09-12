package com.kdu.smartHome.service;

import com.kdu.smartHome.dto.AddDeviceDTO;
import com.kdu.smartHome.dto.InventoryRequestDTO;
import com.kdu.smartHome.dto.InventoryResponseDTO;
import com.kdu.smartHome.exception.customexception.DeviceNotFoundException;
import com.kdu.smartHome.exception.customexception.HouseNotFoundException;
import com.kdu.smartHome.exception.customexception.InvalidCredException;
import com.kdu.smartHome.exception.customexception.UnavailableDeviceException;
import com.kdu.smartHome.mapping.InventoryDtoToInventory;
import com.kdu.smartHome.model.House;
import com.kdu.smartHome.model.Inventory;
import com.kdu.smartHome.model.Rooms;
import com.kdu.smartHome.repository.HouseDAO;
import com.kdu.smartHome.repository.InventoryDAO;
import com.kdu.smartHome.repository.RoomDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class InventoryService {
    InventoryDAO inventoryDAO;
    HouseDAO houseDAO;
    RoomDAO roomDAO;
    @Autowired
    public InventoryService(InventoryDAO inventoryDAO, HouseDAO houseDAO, RoomDAO roomDAO)
    {
        this.inventoryDAO=inventoryDAO;
        this.houseDAO=houseDAO;
        this.roomDAO=roomDAO;
    }
    public InventoryResponseDTO getAllInventory()
    {

        List<Inventory> inventories=inventoryDAO.findAll();
        InventoryResponseDTO inventoryResponse=new InventoryResponseDTO();
        inventoryResponse.setInventory(inventories.toString());
        inventoryResponse.setStatus(HttpStatus.OK.value());
        return inventoryResponse;
    }
    public void addItem(InventoryRequestDTO inventoryDto)
    {
        Inventory inventory=new Inventory();
        inventory= InventoryDtoToInventory.inventoryDtoToInventory(inventoryDto);
        inventoryDAO.save(inventory);
    }
    public void register(InventoryRequestDTO inventoryRequestDTO)
    {
        Optional<Inventory>req=inventoryDAO.findById(inventoryRequestDTO.getKickstonId());
        if(req.isPresent())
        {

            if ((inventoryRequestDTO.getKickstonId() == req.get().getKickstonId()) &&
                    (!req.get().getUsername().equals(inventoryRequestDTO.getUsername()))) {
                throw new UnavailableDeviceException("Unavailable Device");
            }
            if(req.get().getUsername().equals(inventoryRequestDTO.getUsername())&&req.get().getPassword().equals(inventoryRequestDTO.getPassword()))
            {
                req.get().setVerified(true);
                inventoryDAO.save(req.get());
            }
            else {
                throw new InvalidCredException("Device Not Found");
            }
        }
        else{
            //throw error
            throw new DeviceNotFoundException("Device Not Found");
        }
    }
    public void addDeviceToHome(AddDeviceDTO deviceDTO)
    {
        //log.info(deviceDTO.getHouseId()+" house "+deviceDTO.getRoomId()+" room "+deviceDTO.getKickstoneId()+" kickstone");
        try {
            Optional<House> house = houseDAO.findById(Long.parseLong(deviceDTO.getHouseId()));
            Optional<Rooms> room = roomDAO.findById(Long.parseLong(deviceDTO.getRoomId()));
            Optional<Inventory> inventory = inventoryDAO.findById(Long.parseLong(deviceDTO.getKickstoneId()));
            if(inventory.isPresent()&& !inventory.get().getVerified())
                throw new DeviceNotFoundException("Device Not Registered");
            if (house.isPresent() && room.isPresent() && inventory.isPresent()) {
                Rooms rooms = room.get();
                Inventory in = inventory.get();
                inventoryDAO.save(in);
                rooms.getInventoryList().add(in);
                roomDAO.save(rooms);
            } else {
                throw new DeviceNotFoundException("Device Is Not Registered");
            }
        }
        catch (NumberFormatException e)
        {
            throw new HouseNotFoundException("House with this house id is not present");
        }
    }
}
