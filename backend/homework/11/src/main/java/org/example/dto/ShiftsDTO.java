package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.sql.Date;
import java.sql.Time;


@Data
@AllArgsConstructor
public class ShiftsDTO {

    private String shiftTypeId;
    private String name;
    private Date dateStart;
    private Date dateEnd;
    private Time timeStart;
    private Time timeEnd;
    private String timeZone;
    private String tenantId;
    private String createdBy;
    private String updatedBy;
}
