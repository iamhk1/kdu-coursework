package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.entity.ShiftType;
import org.example.repository.ShiftTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ShiftTypeService {
    ShiftTypeRepository shiftTypeRepository;

    @Autowired
    public ShiftTypeService(ShiftTypeRepository shiftTypeRepository)
    {
        this.shiftTypeRepository=shiftTypeRepository;
    }
    public void addShiftType(ShiftType shiftType)
    {
        log.error(shiftType.toString()+" "+shiftType.getTenantId());
        shiftTypeRepository.save(shiftType);
    }
}
