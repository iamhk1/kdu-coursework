package org.example.controller;

import org.example.entity.ShiftType;
import org.example.service.ShiftTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShiftTypeController {
    ShiftTypeService shiftTypeService;
    public ShiftTypeController(ShiftTypeService shiftTypeService)
    {
        this.shiftTypeService=shiftTypeService;
    }
    @PostMapping("/shifttype")
    public ResponseEntity<String> addShiftType(@RequestBody ShiftType shiftTypes)
    {
        shiftTypeService.addShiftType(shiftTypes);
        return ResponseEntity.ok("Shift Type Added Successfully");
    }
}
