package com.kdu.smartHome.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NewRegisterResponseDTO {
    private String message;
    private String token;
}
