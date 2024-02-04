package com.kdu.smartHome.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserRequestDTO {
    private String username;
    private String password;
    private String name;
    private String firstName;
    private String lastName;
    private String emailId;


}
