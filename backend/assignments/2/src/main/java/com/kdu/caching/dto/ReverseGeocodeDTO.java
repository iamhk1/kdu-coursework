package com.kdu.caching.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class ReverseGeocodeDTO {
    private double latitude;
    private double longitude;
}
