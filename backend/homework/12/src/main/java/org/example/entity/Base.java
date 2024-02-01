package org.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;
@Embeddable
@Data
@AllArgsConstructor

public class Base {
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
