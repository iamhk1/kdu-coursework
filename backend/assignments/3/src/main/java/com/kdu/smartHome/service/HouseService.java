package com.kdu.smartHome.service;

import com.kdu.smartHome.dto.*;
import com.kdu.smartHome.exception.customexception.HouseNotFoundException;
import com.kdu.smartHome.exception.customexception.UserNotFoundException;
import com.kdu.smartHome.model.House;
import com.kdu.smartHome.model.Rooms;
import com.kdu.smartHome.model.User;
import com.kdu.smartHome.repository.HouseDAO;
import com.kdu.smartHome.repository.UsersDAO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HouseService {
    private HouseDAO houseDAO;
    private CustomUserDetailsService userService;
    private UsersDAO usersDAO;
    public HouseService(HouseDAO houseDAO,CustomUserDetailsService userService,UsersDAO usersDAO)
    {
        this.houseDAO=houseDAO;
        this.userService=userService;
        this.usersDAO=usersDAO;
    }

    /**
     *
     * @param house we get house details in HouseRequestDto
     * @return Response Entity having the details of the house
     */
    public ResponseEntity<NewHouseResponseDTO> addHouse(HouseRequestDTO house)
    {
        House newHouse=new House();
        newHouse.setHouseName(house.getHouseName());
        newHouse.setAddress(house.getAddress());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        newHouse.setAdminUsername(authentication.getName());
        houseDAO.save(newHouse);
        User user=userService.getUserByUsername(authentication.getName());
        newHouse.getUsersList().add(user);
        houseDAO.save(newHouse);
        NewHouseResponseDTO response=new NewHouseResponseDTO();
        response.setMessage("House added successfully");
        response.setStatus(HttpStatus.CREATED.value());
        NewHouseResponseDTO.House houseAdded = new NewHouseResponseDTO.House();
        houseAdded.setId(newHouse.getId()+"");
        houseAdded.setAddress(newHouse.getAddress());
        response.setHouseAdded(houseAdded);
        return  ResponseEntity.status(HttpStatus.OK).body(response);

    }

    /**
     *
     * @param houseId House Id to to add user to a particular house
     * @param userDto User details
     */
    public void addNewUser(String houseId, UserRequestDTO userDto)
    {
        User user=new User();
        user=userService.getUserByUsername(userDto.getUsername());
        if(user==null||usersDAO.findByUsername(user.getUsername())==null)
        {
            throw new UserNotFoundException("User Does not exist in database");
        }
        Optional<House> res = houseDAO.findById(Long.parseLong(houseId));

        if(!res.isEmpty()) {
            res.get().getUsersList().add(user);
        }

    }

    /**
     *
     * @return Dto having details of all the houses
     */
    public GetAllHouseDTO findAllHouses()
    {

        List<House>allHouse= houseDAO.findAll();
        GetAllHouseDTO allHouses=new GetAllHouseDTO();
        allHouses.setHouses(allHouse.toString());
        allHouses.setHttpStatus(HttpStatus.OK.value());
        allHouses.setMessage("Fetched All Houses");
        return allHouses;
    }

    /**
     *
     * @param houseId to get house from the database
     * @param houseDTO having the details of the house
     * @return Dto containg the details of the updated house
     */
    public UpdateAddressResponseDTO updateHouse(String houseId, UpdateHouseDTO houseDTO)
    {

        try {
            long houseIdLong = Long.parseLong(houseId);
            if (houseDAO.findById(houseIdLong).isPresent()) {
                House house = houseDAO.findById(houseIdLong).get();
                house.setAddress(houseDTO.getAddress());
                houseDAO.save(house);
                UpdateAddressResponseDTO addressResponseDTO=new UpdateAddressResponseDTO();
                addressResponseDTO.setAddress(houseDTO.getAddress()+" "+houseDTO.getHouseName());
                addressResponseDTO.setStatus(HttpStatus.OK.value());
                addressResponseDTO.setMessage("Updated Successfully");
                return addressResponseDTO;
            } else {

                throw new HouseNotFoundException("House Not Found");
            }
        } catch (NumberFormatException e) {

            throw new HouseNotFoundException("House Not Found");
        }


    }

    /**
     *
     * @param houseId to get house from the database
     * @return all the rooms in a particular house and all the devices in rooms
     * @throws HouseNotFoundException exception
     */
    public HousesDevicesDTO getAllRoomsAndDevices(String houseId) throws HouseNotFoundException
    {
        Optional<House> optionalHouse = houseDAO.findById(Long.parseLong(houseId));
        if(optionalHouse.isEmpty()){
            throw new HouseNotFoundException("No such house");
        }
        House house = optionalHouse.get();
        List<Rooms> rooms = house.getRoomsList();
        String roomsString = rooms.toString();
        String houseString = house.getAddress()+" "+house.getId()+" "+house.getHouseName();
        HousesDevicesDTO houseDto = new HousesDevicesDTO();
        houseDto.setRoomsAndDevices(roomsString+" "+houseString);
        houseDto.setStatus(HttpStatus.OK.value());
        houseDto.setMessage("Fetched all rooms and houses");
        return houseDto;
    }
}
