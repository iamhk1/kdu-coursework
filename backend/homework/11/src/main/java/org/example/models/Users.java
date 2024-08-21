package org.example.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Users {
    private String id;
    private String username;
    private short loggedin;
    private String timeZone;
    private String tenantId;
    private String createdBy;
    private String updatedBy;
    private Instant createdAt;
    private Instant updatedAt;

    public  Users(String username,short loggedin,String timeZone,String tenantInd,String createdBy,String updatedBy,Instant createdAt,Instant updatedAt)
    {
        this.username=username;
        this.loggedin=loggedin;
        this.timeZone=timeZone;
        this.tenantId=tenantInd;
        this.createdBy=createdBy;
        this.createdAt=createdAt;
        this.updatedBy=updatedBy;
        this.updatedAt=updatedAt;
    }

}
