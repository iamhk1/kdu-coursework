package com.kdu.smartHome.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
public class RoomResponseDTO {
    private String message;
    @JsonProperty("room")
    private RoomDetails roomDetails;
    @Data
    @AllArgsConstructor
    public static class RoomDetails{
        private String id;
    }
    private int status;
}
