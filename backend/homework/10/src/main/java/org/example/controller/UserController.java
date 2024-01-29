package org.example.controller;

import org.example.dto.UserDTO;
import org.example.dto.UserReturnDTO;
import org.example.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    UserService userService;
    public UserController(UserService userService){
        this.userService=userService;
    }
    @GetMapping("/user/get")
    public List<UserReturnDTO> getAllUser()
    {

        return userService.getAllUsers();
    }
    @GetMapping("/user/{name}")
    public UserReturnDTO getUserWithName(@PathVariable String name)
    {
        return userService.getUserWithName(name);
    }
    @PostMapping("/useradd")
    public ResponseEntity<String> addUser(@RequestBody UserDTO userdto){
        userService.addNewUser(userdto);
        return ResponseEntity.ok("User Added Successfully");
    }
}
