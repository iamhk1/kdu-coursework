package com.kdu.caching.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *Whenever an Exception occurs,the response will be sent in this format
 */
@Data
@AllArgsConstructor
public class ErrorDTO {
    String message;
    int status;
}
