package com.kdu.caching.service;
import com.kdu.caching.dto.GeocodeDTO;
import com.kdu.caching.repo.GeocodingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *We inject the Repository Dependency over here
 *We just call the convert function in the repo and send the latitude and longitude
 * Since there are just two arguments ,we pass it as a string only
 */
@Service
public class ReverseGeocodingService {

    GeocodingRepository repo;
    @Autowired
    public ReverseGeocodingService(GeocodingRepository repo)
    {
        this.repo=repo;
    }
    public  GeocodeDTO convertLatLongToAddress(String lat,String lon)
    {
         return repo.repoConvertLatLongToAddress(lat,lon);
    }
}
