package com.kdu.caching.repo;

import com.kdu.caching.dto.GeocodeDTO;
import com.kdu.caching.dto.ReverseGeocodeDTO;
import com.kdu.caching.exception.customexception.AddressNotFoundException;
import com.kdu.caching.model.Geocoding;
import com.kdu.caching.model.ReverseGeocoding;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
@Slf4j
@Repository
public class GeocodingRepository implements com.kdu.caching.repo.Repository {

    /**
     *api-key has been stored in applications.properties and is being accessed from there
     */
    @Value("${api-key}")
    String getApiKey;

    /**
     *We are using the caching mechanism
     * The condition here prevents us from caching address 'goa' in the cache
     * We generate the url using the apiKey and the address and then make a third party api call
     * Check for exception
     *
     */
    @Cacheable(value = "geocoding", cacheManager = "cacheManager",condition = "!#address.equals('goa')")
    @Override
    public  ReverseGeocodeDTO repoConvertAddressToLatLong(String address)
    {

        String generateURL="http://api.positionstack.com/v1/forward?access_key="+getApiKey+"&query="+address;
        WebClient.Builder builder=WebClient.builder();
        Geocoding allLatLong=builder
                .build()
                .get()
                .uri(generateURL)
                .retrieve()
                .bodyToMono(Geocoding.class)
                .block();
        if(allLatLong==null||allLatLong.getData().length==0) {
            log.error("Co-ordinates not found");
            throw new AddressNotFoundException("Co-ordinates Not found");
        }
        log.info("Latitude:"+allLatLong.getData()[0].getLatitude()+" Longitude:"+allLatLong.getData()[0].getLongitude());
        return new ReverseGeocodeDTO(Double.parseDouble(allLatLong.getData()[0].getLatitude()),Double.parseDouble(allLatLong.getData()[0].getLongitude()));
    }

    /**
     *For reverseGeocoding , we take the latitude and longitude and make a url accordingly
     * We make a third party application call and get the data from there
     * Check for exceptions
     * Since test folder wants response in the form of string , we design our DTO in a specific way
     */
    @Cacheable(value = "reverse-geocoding", cacheManager = "cacheManager")
    @Override
    public  GeocodeDTO repoConvertLatLongToAddress(String lat,String lon)
    {
        String generateURL="http://api.positionstack.com/v1/reverse?access_key="+getApiKey+"&query="+lat+","+lon;
        WebClient.Builder builder=WebClient.builder();
        ReverseGeocoding allLatLong=builder
                .build()
                .get()
                .uri(generateURL)
                .retrieve()
                .bodyToMono(ReverseGeocoding.class)
                .block();
        if(allLatLong==null||allLatLong.getAddress().length==0) {
            log.error("Address does not exist");
            throw new AddressNotFoundException("Address Does not exist");
        }
        log.info(allLatLong.getAddress()[0].getName()+","+allLatLong.getAddress()[0].getCountry());
        return new GeocodeDTO(allLatLong.getAddress()[0].getName()+","+
                allLatLong.getAddress()[0].getLocality()+","+
                allLatLong.getAddress()[0].getPostcode()+","+
                allLatLong.getAddress()[0].getCountry());
    }
}
