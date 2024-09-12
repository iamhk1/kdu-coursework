package com.kdu.smartHome.controllers;


import com.kdu.smartHome.auth.JwtUtil;
import com.kdu.smartHome.dto.ErrorDTO;
import com.kdu.smartHome.dto.NewRegisterResponseDTO;
import com.kdu.smartHome.dto.UserRequestDTO;
import com.kdu.smartHome.model.User;
import com.kdu.smartHome.service.CustomUserDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Slf4j
@Controller
@RequestMapping("/api/v1")
public class AuthController {
    CustomUserDetailsService userService;
    private final AuthenticationManager authenticationManager;

    private JwtUtil jwtUtil;
    @Autowired
    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil,CustomUserDetailsService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userService=userService;

    }

    /**
     *
     * @param userRequestDTO Getting parameters
     * @return Registered user
     */
    @PostMapping("/auth/register")
    public ResponseEntity<NewRegisterResponseDTO> login(@RequestBody UserRequestDTO userRequestDTO)  {

        try {

              User user=userService.addUser(userRequestDTO);
            String token = jwtUtil.createToken(user);
            log.info("work done");
            NewRegisterResponseDTO response=new NewRegisterResponseDTO();
            response.setMessage("User Registered Successfully");
            response.setToken(token);
            return new ResponseEntity<>(response,HttpStatus.OK);

        }catch (BadCredentialsException e){
            NewRegisterResponseDTO response=new NewRegisterResponseDTO();
            response.setMessage("Registration Failed");
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }catch (Exception e){

            NewRegisterResponseDTO response=new NewRegisterResponseDTO();
            response.setMessage("Registration Failed");
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
    }
}