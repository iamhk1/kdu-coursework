package com.kdu.smartHome.dto;

import lombok.Data;

@Data
public class UpdateAddressResponseDTO {
    private String message;
    private String address;
    private int status;
}
