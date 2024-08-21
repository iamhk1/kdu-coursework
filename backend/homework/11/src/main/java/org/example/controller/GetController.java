package org.example.controller;

import org.example.dto.*;
import org.example.models.Users;
import org.example.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GetController {
    MainService service;
    @Autowired
    public GetController(MainService service)
    {
        this.service=service;
    }

    @GetMapping("/user/{id}")
    public UsersDTO getUser(@PathVariable String id)
    {
        return service.getUser(id);

    }
    @GetMapping("/shiftuser/{id}")
    public ShiftUserDTO getShiftUser(@PathVariable String id)
    {

        return service.getShiftUser(id);
    }
    @GetMapping("/shifttype/{id}")
    public ShiftTypesDTO getShiftType(@PathVariable String id)
    {
        return service.getShiftType(id);

    }
    @GetMapping("/shift/{id}")
    public ShiftsDTO addShift(@PathVariable String id)
    {
       return service.getShift(id);
    }
    @PutMapping("/updateuser")
    public ResponseEntity<String>updateUser(@RequestBody Users user)
    {
        service.updateUser(user);
        return ResponseEntity.ok("User updated Successfully");

    }

}
