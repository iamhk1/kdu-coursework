package org.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import lombok.Data;


@Data
@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "CHAR(36) DEFAULT (UUID())")
    private String id;

    @Column(name = "username")
    @JsonProperty("username")
    private String username;

    @Column(name = "loggedin")
    @JsonProperty("loggedin")
    private short loggedin;

    @Column(name = "time_zone")
    @JsonProperty("timeZone")
    private String timeZone;


    @Embedded
    private Base base;

    @OneToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "tenant_id", referencedColumnName = "id")
    @JsonProperty("tenantId")
    private Tenant tenantId;
}
