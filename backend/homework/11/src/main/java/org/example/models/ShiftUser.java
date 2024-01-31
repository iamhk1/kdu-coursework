package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShiftUser {
    private String id;
    private String shiftId;
    private String userId;
    private String tenantId;
    private String createdBy;
    private String updatedBy;
    private Instant createdAt;
    private Instant updatedAt;
    public ShiftUser(String shiftId, String userId, String tenantId, String createdBy, String updatedBy, Instant createdAt, Instant updatedAt) {
        this.shiftId = shiftId;
        this.userId = userId;
        this.tenantId = tenantId;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
