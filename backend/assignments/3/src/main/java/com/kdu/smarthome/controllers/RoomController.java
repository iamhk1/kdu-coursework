package com.kdu.smartHome.controllers;

import com.kdu.smartHome.dto.RoomRequestDTO;
import com.kdu.smartHome.dto.RoomResponseDTO;
import com.kdu.smartHome.service.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/v1")
public class RoomController {
    RoomService roomService;
    @Autowired
    public RoomController(RoomService roomService)
    {
        this.roomService=roomService;
    }
    @PostMapping("/room")
    public ResponseEntity<RoomResponseDTO>addRoom(@RequestParam String houseId, @RequestBody  RoomRequestDTO roomDto)
    {

        return roomService.addRoom(houseId,roomDto);

    }
}
