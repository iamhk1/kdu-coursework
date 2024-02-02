package org.example.controller;

import org.example.dto.UserDTO;
import org.example.entity.Users;
import org.example.service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    UsersService usersService;
    public UserController(UsersService usersService)
    {
        this.usersService=usersService;
    }
    @PostMapping("/user")
    public ResponseEntity<String> addUser(@RequestBody UserDTO user)
    {
            usersService.addUser(user);
            return ResponseEntity.ok("User added successfully");
    }
}
