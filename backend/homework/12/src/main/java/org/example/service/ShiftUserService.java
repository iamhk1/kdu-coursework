package org.example.service;

import org.example.entity.ShiftUser;
import org.example.repository.ShiftUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ShiftUserService {
    ShiftUserRepository shiftUserRepository;
    @Autowired
    public ShiftUserService(ShiftUserRepository shiftUserRepository)
    {
        this.shiftUserRepository=shiftUserRepository;
    }
    public void addShiftUser(ShiftUser shiftUser)
    {
        shiftUserRepository.save(shiftUser);
    }
    public List<ShiftUser> getAllShiftUsers() {
        return shiftUserRepository.findAll();
    }



}
