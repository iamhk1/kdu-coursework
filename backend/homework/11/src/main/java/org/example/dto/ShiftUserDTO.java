package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.security.Timestamp;
@AllArgsConstructor
@Data
public class ShiftUserDTO {

    private String shiftId;
    private String userId;
    private String tenantId;
    private String createdBy;
    private String updatedBy;

}
