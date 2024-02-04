package com.kdu.smartHome.dto;

import lombok.Data;

@Data
public class GetAllHouseDTO {
    private String message;
    private String houses;
    private int httpStatus;
}

