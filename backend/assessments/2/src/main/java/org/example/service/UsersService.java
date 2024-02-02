package org.example.service;

import org.example.dao.UsersRepository;
import org.example.dto.UserDTO;
import org.example.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    UsersRepository usersRepository;
    @Autowired
    public UsersService(UsersRepository usersRepository)
    {
        this.usersRepository=usersRepository;
    }
    public void addUser(UserDTO user)
    {
        Users newUser=new Users();
        newUser.setEmail(user.getEmail());
        newUser.setName(user.getName());
        newUser.setAddress(user.getAddress());
        newUser.setCart(user.getCart());
        usersRepository.save(newUser);
    }


}
