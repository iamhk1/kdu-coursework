package com.kdu.smartHome.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class NewHouseResponseDTO {
    private String message;
    @JsonProperty("house")
    private House houseAdded;
    @Data
    public static class House{
        private String id;
        private String address;
    }
    int status;

}
