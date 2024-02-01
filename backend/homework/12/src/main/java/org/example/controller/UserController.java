package org.example.controller;

import org.example.entity.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {
    UserService userService;
    @Autowired
    public UserController(UserService userService)
    {
        this.userService=userService;
    }
    @PostMapping("/user")
    public ResponseEntity<String> addUser(@RequestBody User user)
    {
        userService.addNewUser(user);
        return ResponseEntity.ok("New User Added Successfully");
    }
    @GetMapping("/all")
    public ResponseEntity<Page<User>> findAllUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "50") int size) {
        page = Math.max(0, page);
        size = Math.min(50, Math.max(1, size));

        Pageable pageable = PageRequest.of(page, size);
        Page<User> userPage = userService.getAllUserPage(pageable);

        return ResponseEntity.ok(userPage);
    }

}
