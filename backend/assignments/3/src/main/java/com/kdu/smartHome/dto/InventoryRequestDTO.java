package com.kdu.smartHome.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Id;
import lombok.Data;

import java.sql.Timestamp;
@Data
public class InventoryRequestDTO {
    @Id
    @JsonProperty("kickston_id")
    private long kickstonId;
    @JsonProperty("device_username")
    private String username;
    @JsonProperty("device_password")
    private String password;
    @JsonProperty("manufacture_date_time")
    private Timestamp manufactureDateTime;
    @JsonProperty("manufacture_factory_place")
    private String manufacturePlace;

}
