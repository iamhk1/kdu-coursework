package org.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "shift_user")
public class ShiftUser {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "CHAR(36) DEFAULT (UUID())")
    private String id;


    @OneToOne
    @JsonProperty("userId")
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User userId;
    @OneToOne( )
    @JsonProperty("shiftId")
    @JoinColumn(name = "shift_id", referencedColumnName = "id")
    private Shift shiftId;
    @OneToOne()
    @JsonProperty("tenantId")
    @JoinColumn(name = "tenant_id", referencedColumnName = "id")
    private Tenant tenantId;

    @Embedded
    Base base;
}
