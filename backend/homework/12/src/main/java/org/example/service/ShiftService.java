package org.example.service;

import org.example.entity.Shift;
import org.example.repository.ShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ShiftService {
    ShiftRepository shiftRepository;
    @Autowired
    public ShiftService(ShiftRepository shiftRepository)
    {
        this.shiftRepository=shiftRepository;
    }
      public void addShift(Shift shift)
      {
          shiftRepository.save(shift);
      }
    public List<Shift> findTop3ShiftsByDateRange(LocalDate startDate, LocalDate endDate) {
        return shiftRepository.findTop3ShiftsByDateRange(startDate, endDate);
    }
}
