package com.kdu.caching.service;

import com.kdu.caching.dto.ReverseGeocodeDTO;
import com.kdu.caching.repo.GeocodingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *We inject the Repository Dependency over here
 *We just call the convert function in the repo and send the address string
 * Since there is just one argument ,we pass it as a string only
 */
@Service
public class GeocodingService {

    GeocodingRepository repo;
    @Autowired
    public GeocodingService(GeocodingRepository repo)
    {
        this.repo=repo;
    }
    public   ReverseGeocodeDTO convertAddressToLatLong(String address) {

        return repo.repoConvertAddressToLatLong(address);
    }
}
