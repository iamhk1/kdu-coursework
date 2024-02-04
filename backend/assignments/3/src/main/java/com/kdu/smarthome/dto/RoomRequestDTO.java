package com.kdu.smartHome.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RoomRequestDTO {
        @JsonProperty("room_name")
        private String roomName;
}
