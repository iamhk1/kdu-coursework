package com.kdu.smartHome.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HouseRequestDTO {
    @JsonProperty("address")
    private String address;
    @JsonProperty("house_name")
    private String houseName;
}
