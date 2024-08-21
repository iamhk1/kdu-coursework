package org.example.controller;

import org.example.dto.*;
import org.example.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    MainService service;
    @Autowired
    public Controller(MainService service)
    {
        this.service=service;
    }

    @PostMapping("/user")
    public ResponseEntity<String> addUser(@RequestBody UsersDTO user)
    {
        service.addNewUser(user);
        return ResponseEntity.ok("New User Added Successfully");
    }
    @PostMapping("/shiftuser")
    public ResponseEntity<String> addShiftUser(@RequestBody ShiftUserDTO shiftUserDTO)
    {
        service.addShiftUser(shiftUserDTO);
        return ResponseEntity.ok("ShiftUser Added Successfully");
    }
    @PostMapping("/shifttype")
    public ResponseEntity<String> addShiftType(@RequestBody ShiftTypesDTO shiftTypesDTO)
    {
        service.addShiftType(shiftTypesDTO);
        return ResponseEntity.ok("Shift Type Added Successfully");
    }
    @PostMapping("/shift")
    public ResponseEntity<String> addShift(@RequestBody ShiftsDTO shiftsDTO)
    {
        service.addShift(shiftsDTO);
        return ResponseEntity.ok("Shift Added Successfully");
    }
    @PostMapping("/all")
    public ResponseEntity<String> addAllValues(@RequestBody AllDTO allDTO)
    {
        service.addAll(allDTO);
        return ResponseEntity.ok("All the Values Added Successfully");
    }
}
