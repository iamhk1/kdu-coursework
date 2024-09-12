package com.kdu.smartHome.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Entity
@Data
@NoArgsConstructor
@Table(name = "user_table")
public class User {
    @Id
    private String username;
    private String password;
    private String name;
    private String firstName;
    private String lastName;
    private String emailId;
    private String role;
}
