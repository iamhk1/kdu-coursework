package com.kdu.caching.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetAddress {
        private String locality;
        private String postcode;
        private String country;
        private String name;

}
