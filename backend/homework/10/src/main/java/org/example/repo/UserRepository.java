package org.example.repo;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.UserDTO;
import org.example.dto.UserReturnDTO;
import org.example.exception.customexception.EmptyListException;
import org.example.exception.customexception.UserAlreadyExistsException;
import org.example.exception.customexception.UserNotFoundException;
import org.example.model.Users;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Repository
public class UserRepository {
    List<Users> userList=new ArrayList<>();
    public List<UserReturnDTO> getAllUsers()
    {
        if(userList.isEmpty())
        {
            log.error("The list empty");
            throw new EmptyListException("The list is empty");
        }
        List<UserReturnDTO>allUser=new ArrayList<>();
        for(Users user:userList)
        {
            allUser.add(new UserReturnDTO(user.getUserName(),user.getEmail()));
        }
        log.info("All the users have been fetched");
        return allUser;
    }
    public UserReturnDTO getUserWithName(String name)
    {
        for(Users user:userList)
        {
            if(user.getUserName().equals(name))
            {
                log.info("User found");
                return new UserReturnDTO(user.getUserName(), user.getEmail());
            }
        }
        log.error("User does not exist");
        throw new UserNotFoundException("User with this name does  not exist");
    }
    public void addNewUser(UserDTO userDto)
    {
        for(Users user:userList)
        {
            if(user.getUserName().equals(userDto.getUserName())) {
                log.error("User with this name already exists");
                throw new UserAlreadyExistsException("User with this name already exists");
            }
        }
        Users newUser=new Users(userDto.getUserName(),userDto.getPassword(),userDto.getEmail());
        log.info("New user added successfully");
        userList.add(newUser);
    }

}
