package com.kdu.smartHome.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UpdateHouseDTO {
    @JsonProperty("address")
    private String address;
    @JsonProperty("house_name")
    private String houseName;
}
