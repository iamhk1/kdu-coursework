package com.kdu.caching.repo;

import com.kdu.caching.dto.GeocodeDTO;
import com.kdu.caching.dto.ReverseGeocodeDTO;

public interface Repository {
    public ReverseGeocodeDTO repoConvertAddressToLatLong(String address);
    public GeocodeDTO repoConvertLatLongToAddress(String lat, String lon);

}
