package org.example.controller;

import org.example.entity.ShiftUser;
import org.example.service.ShiftUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShiftUserController {
    ShiftUserService shiftUserService;
    @Autowired
    public ShiftUserController(ShiftUserService shiftUserService)
    {
        this.shiftUserService=shiftUserService;
    }
    @PostMapping("/shiftuser")
    public ResponseEntity<String> addShiftUser(@RequestBody ShiftUser shiftUser)
    {
        shiftUserService.addShiftUser(shiftUser);
        return ResponseEntity.ok("ShiftUser Added Successfully");
    }

}
