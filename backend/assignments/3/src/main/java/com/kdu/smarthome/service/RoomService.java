package com.kdu.smartHome.service;

import com.kdu.smartHome.dto.RoomRequestDTO;
import com.kdu.smartHome.dto.RoomResponseDTO;
import com.kdu.smartHome.exception.customexception.UserNotFoundException;
import com.kdu.smartHome.mapping.RoomDtoToRoom;
import com.kdu.smartHome.model.House;
import com.kdu.smartHome.model.Rooms;
import com.kdu.smartHome.repository.HouseDAO;
import com.kdu.smartHome.repository.RoomDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoomService {
    private HouseDAO houseDAO;
    private RoomDAO roomDAO;
    @Autowired
    public RoomService(RoomDAO roomDAO, HouseDAO houseDAO)
    {
        this.houseDAO=houseDAO;
        this.roomDAO=roomDAO;
    }

    /**
     *
     * @param houseId to search for house in the database
     * @param roomDto getting details of the room
     * @return returning updated rooms details
     */
    public ResponseEntity<RoomResponseDTO> addRoom(String houseId, RoomRequestDTO roomDto)
    {
        Rooms rooms=new Rooms();
        rooms= RoomDtoToRoom.roomDtoToRoom(roomDto);
        Rooms getRooms=roomDAO.save(rooms);
        try {
            Optional<House> res = houseDAO.findById(Long.parseLong(houseId));
            if(res.isPresent()){
                res.get().getRoomsList().add(rooms);
                houseDAO.save(res.get());
            }
            RoomResponseDTO roomDetails = new RoomResponseDTO();
            roomDetails.setStatus(HttpStatus.OK.value());
            roomDetails.setMessage("Room added succadasd");
            roomDetails.setRoomDetails(new RoomResponseDTO.RoomDetails(getRooms.getId().toString()));
            return  ResponseEntity.status(HttpStatus.OK).body(roomDetails);
        }
        catch(NumberFormatException ex)
        {
            throw new UserNotFoundException("Invalid House Id");
        }

    }
}
