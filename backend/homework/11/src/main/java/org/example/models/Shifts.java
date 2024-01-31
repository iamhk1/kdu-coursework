package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shifts {
    private String id;
    private String shiftTypeId;
    private String name;
    private Date dateStart;
    private Date dateEnd;
    private Time timeStart;
    private Time timeEnd;
    private Instant createdAt;
    private Instant updatedAt;
    private String timeZone;
    private String tenantId;
    private String createdBy;
    private String updatedBy;
    public Shifts(String shiftTypeId, String name, Date dateStart, Date dateEnd, Time timeStart, Time timeEnd, Instant createdAt, Instant updatedAt, String timeZone, String tenantId, String createdBy, String updatedBy) {
        this.shiftTypeId = shiftTypeId;
        this.name = name;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.timeZone = timeZone;
        this.tenantId = tenantId;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }
}
