package com.kdu.smartHome.service;



import com.kdu.smartHome.dto.UserRequestDTO;
import com.kdu.smartHome.mapping.UserDtoToUser;
import com.kdu.smartHome.repository.UsersDAO;
import com.kdu.smartHome.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private  UsersDAO usersDAO;
    private UserDtoToUser convert;
    @Autowired
    public CustomUserDetailsService(UsersDAO usersDAO,UserDtoToUser convert)
    {
        this.usersDAO=usersDAO;
        this.convert=convert;
    }

    /**
     *
     * @param username the username identifying the user whose data is required.
     * @return User Details
     * @throws UsernameNotFoundException When an invalid username is entered
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = usersDAO.findByUsername(username);
        List<String> roles = new ArrayList<>();
        roles.add("USER");
        UserDetails userDetails =
                org.springframework.security.core.userdetails.User.builder()
                        .username(user.getUsername())
                        .password(user.getPassword())
                        .roles(roles.toArray(new String[0]))
                        .build();
        return userDetails;
    }

    /**
     *
     * @param userDto having user attributes
     * @return User Object
     */
    public User addUser(UserRequestDTO userDto)
    {
        User user=new User();
        user=convert.userDtoToUser(userDto);
        usersDAO.save(user);
        return user;
    }

    /**
     *
     * @param username
     * @return Entire user object from username
     */
    public User getUserByUsername(String username)
    {

        return usersDAO.findByUsername(username);
    }
    public String getRoleByUsername(String username)
    {
        return usersDAO.findByUsername(username).getUsername();
    }

}
