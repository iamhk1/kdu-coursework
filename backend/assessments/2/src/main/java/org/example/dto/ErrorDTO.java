package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
/**
 * Error message
 */
public class ErrorDTO {
    String message;
    int statusCode;
}

