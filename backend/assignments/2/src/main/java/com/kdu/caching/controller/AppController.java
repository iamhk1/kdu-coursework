package com.kdu.caching.controller;
import com.kdu.caching.dto.ReverseGeocodeDTO;
import com.kdu.caching.service.GeocodingService;
import com.kdu.caching.service.ReverseGeocodingService;
import com.kdu.caching.validations.LatitudeLongitudeValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AppController implements Controller{
        GeocodingService geocodingService;
        ReverseGeocodingService reverseGeocodingService;

    /**
     *Injeting the Service dependency in Controller
     */
        @Autowired
        AppController(GeocodingService geocodingService,ReverseGeocodingService reverseGeocodingService)
        {

            this.geocodingService=geocodingService;
            this.reverseGeocodingService=reverseGeocodingService;
        }

    /**
     *API call for forward Feocoding
     */
    @GetMapping("/geocoding")
    @Override
    public ReverseGeocodeDTO addressToLatLong(@RequestParam String address)
    {
        return geocodingService.convertAddressToLatLong(address);
    }

    /**
     *API call for reverse geocoding
     * Here, According to the tests, we had to return a String
     */
    @GetMapping("/reverse-geocoding")
    @Override
    public ResponseEntity<String> latLongToAddress(@RequestParam String lat, @RequestParam String lon)
    {
        LatitudeLongitudeValidation.checkValidation(lat,lon);
        String s= reverseGeocodingService.convertLatLongToAddress(lat,lon).getAddress();
        return ResponseEntity.ok(s);
    }

}