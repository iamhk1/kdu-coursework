package com.kdu.smartHome.mapping;

import com.kdu.smartHome.dto.UserRequestDTO;
import com.kdu.smartHome.model.User;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class UserDtoToUser {

    public User userDtoToUser(UserRequestDTO userDTO)
    {
        User user=new User();
        user.setUsername(userDTO.getUsername());
        log.info("password"+userDTO.getPassword());
        user.setPassword(userDTO.getPassword());
        user.setName(userDTO.getName());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmailId(userDTO.getEmailId());
        user.setRole("ROLE_USER");
        return user;
    }
}
