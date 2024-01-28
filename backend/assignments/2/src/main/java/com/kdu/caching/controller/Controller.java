package com.kdu.caching.controller;
import com.kdu.caching.dto.ReverseGeocodeDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *Interace for the controller
 */
public interface Controller {
    public ReverseGeocodeDTO addressToLatLong(@RequestParam String address);
    public ResponseEntity<String> latLongToAddress(@RequestParam String lat, @RequestParam String lon);
}
