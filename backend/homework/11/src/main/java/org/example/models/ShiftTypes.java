package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShiftTypes {
    private String id;
    private String uqName;
    private String description;
    private Boolean active;
    private Instant createdAt;
    private Instant updatedAt;
    private String timeZone;
    private String tenantId;
    private String createdBy;
    private String updatedBy;
    public ShiftTypes(String uqName, String description, Boolean active, Instant createdAt, Instant updatedAt, String timeZone, String tenantId, String createdBy, String updatedBy) {
        this.uqName = uqName;
        this.description = description;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.timeZone = timeZone;
        this.tenantId = tenantId;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }
}
