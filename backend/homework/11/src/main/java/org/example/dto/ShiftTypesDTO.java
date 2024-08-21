package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ShiftTypesDTO {

    private String uqName;
    private String description;
    private Boolean active;
    private String timeZone;
    private String tenantId;
    private String createdBy;
    private String updatedBy;
    public boolean getActive()
    {
        return active;
    }
}
