package org.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
@Data
@Table(name = "shift_types")
public class ShiftType {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "CHAR(36) DEFAULT (UUID())")
    private String id;

    @Column(name = "uq_name")
    @JsonProperty("uqName")
    private String uqName;

    @Column(name = "description")
    @JsonProperty("description")
    private String description;

    @Column(name = "active")
    @JsonProperty("active")
    private Boolean active;


    @Column(name = "time_zone")
    @JsonProperty("timeZone")
    private String timeZone;



    @OneToOne
    @JoinColumn(name = "tenant_id", referencedColumnName = "id")
    @JsonProperty("tenantId")
    private Tenant tenantId;

    @Column(name="created_by")
    @JsonProperty("createdBy")
    private String createdBy;

    @Column(name="updated_by")
    @JsonProperty("updatedBy")
    private String updatedBy;

    @Column(name = "created_at")
    @CreationTimestamp
    private Instant createdAt;

    @Column(name = "updated_at")
    @CreationTimestamp
    private Instant updatedAt;
}