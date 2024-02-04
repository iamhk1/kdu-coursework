package com.kdu.smartHome.mapping;

import com.kdu.smartHome.dto.HouseRequestDTO;
import com.kdu.smartHome.model.House;


public class HouseDtoToHouse {

    public static House convertDtoToHouse(HouseRequestDTO houseDTO)
    {
        House house=new House();
        house.setHouseName(houseDTO.getHouseName());
        house.setAddress(houseDTO.getAddress());

        return house;
    }
}
