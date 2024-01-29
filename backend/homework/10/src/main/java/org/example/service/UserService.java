package org.example.service;

import org.example.dto.UserDTO;
import org.example.dto.UserReturnDTO;
import org.example.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    UserRepository userRepo;
    @Autowired
    public UserService(UserRepository userRepo)
    {
        this.userRepo=userRepo;
    }
    public List<UserReturnDTO> getAllUsers()
    {
        return userRepo.getAllUsers();
    }
    public UserReturnDTO getUserWithName(String name)
    {
        return userRepo.getUserWithName(name);
    }
    public void addNewUser(UserDTO user)
    {
        userRepo.addNewUser(user);
    }
}
