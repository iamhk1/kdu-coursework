package com.kdu.smartHome.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data

public class AddDeviceDTO {
    @JsonProperty("houseId")
    private String houseId;
    @JsonProperty("roomId")
    private String roomId;
    @JsonProperty("kickstonId")
    private String kickstoneId;
}
