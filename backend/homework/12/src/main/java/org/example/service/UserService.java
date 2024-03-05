package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.entity.User;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class UserService {
    UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository)
    {
        this.userRepository=userRepository;
    }
    public void addNewUser(User user){
        log.info(user.toString());
        userRepository.save(user);
    }
    public Page<User> getAllUserPage(Pageable pageable)
    {
        return userRepository.findAll(pageable);
    }
}
