package com.kdu.caching.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetCoordinates {

        private String latitude;
        private String longitude;
}
