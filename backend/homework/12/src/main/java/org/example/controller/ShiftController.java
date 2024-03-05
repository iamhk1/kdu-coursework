package org.example.controller;
import org.example.entity.Shift;
import org.example.service.ShiftService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class ShiftController {
    ShiftService shiftService;
    public ShiftController(ShiftService shiftService)
    {
        this.shiftService=shiftService;
    }
    @PostMapping("/shift")
    public ResponseEntity<String> addShift(@RequestBody Shift shift)
    {
        shiftService.addShift(shift);
        return ResponseEntity.ok("Shift Added Successfully");
    }
    @GetMapping("/top3")
    public ResponseEntity<List<Shift>> getTop3ShiftsByDateRange(
            @RequestParam("startDate") @DateTimeFormat(pattern = "dd-MMM-yyyy") LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(pattern = "dd-MMM-yyyy") LocalDate endDate) {
        List<Shift> top3Shifts = shiftService.findTop3ShiftsByDateRange(startDate, endDate);
        return new ResponseEntity<>(top3Shifts, HttpStatus.OK);
    }
}
