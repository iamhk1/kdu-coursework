package org.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;
import java.time.Instant;


@Data
@Entity
@Table(name="shift")
public class Shift {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "CHAR(36) DEFAULT (UUID())")
    private String id;

    @ManyToOne
    @JoinColumn(name = "shift_type_id", columnDefinition = "CHAR(36)", referencedColumnName = "id")
    private ShiftType shiftType;

    @OneToOne
    @JoinColumn(name = "tenant_id", columnDefinition = "CHAR(36)", referencedColumnName = "id")
    private Tenant tenantId;

    @Column(name = "name")
    private String name;

    @Column(name = "date_start")
    private Date dateStart;

    @Column(name = "date_end")
    private Date dateEnd;

    @Column(name = "time_start")
    private Time timeStart;

    @Column(name = "time_end")
    private Time timeEnd;

    @Column(name = "time_zone")
    private String timeZone;

    @Column(name="created_by")
    @JsonProperty("CreatedBy")
    private String createdBy;

    @Column(name="updated_by")
    @JsonProperty("UpdatedBy")
    private String updatedBy;

    @Column(name = "created_at")
    @JsonProperty("CreatedAt")
    private Instant createdAt;

    @Column(name = "updated_at")
    @JsonProperty("UpdatedAt")
    private Instant updatedAt;

}
