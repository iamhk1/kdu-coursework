package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UsersDTO {

    private String username;
    private short loggedin;
    private String timeZone;
    private String tenantId;
    private String updatedBy;
    private String createdBy;
}
