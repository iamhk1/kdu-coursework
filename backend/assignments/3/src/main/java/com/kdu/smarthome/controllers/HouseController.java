package com.kdu.smartHome.controllers;

import com.kdu.smartHome.dto.*;

import com.kdu.smartHome.service.HouseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
@RequestMapping("/api/v1")

public class HouseController {
    private  HouseService houseService;
    @Autowired
    public HouseController(HouseService houseService)
    {
        this.houseService=houseService;
    }
        @PostMapping("/house")

        public ResponseEntity<NewHouseResponseDTO> addHouse(@RequestBody  HouseRequestDTO house)
        {

            return houseService.addHouse(house);

        }
        @PostMapping("/house/{houseId}/add-user")
        public void addUserToHouse(@PathVariable String houseId, @RequestBody UserRequestDTO userDto)
        {
            houseService.addNewUser( houseId, userDto);
        }
        @GetMapping("/house")
        public ResponseEntity<GetAllHouseDTO> allHouses()
        {

            GetAllHouseDTO allHouse= houseService.findAllHouses();
            return ResponseEntity.ok(allHouse);
        }
        @PutMapping("/house")
        public ResponseEntity<UpdateAddressResponseDTO>  updateHouse(@RequestParam String houseId ,@RequestBody UpdateHouseDTO houseDto)
        {
            UpdateAddressResponseDTO response=houseService.updateHouse(houseId,houseDto);
            return new ResponseEntity<>(response, HttpStatus.OK);

        }
        @GetMapping("/house/{houseId}")
        public ResponseEntity<HousesDevicesDTO> getAllRoomsAndDevices(@PathVariable String houseId)
        {
                HousesDevicesDTO housedevices=houseService.getAllRoomsAndDevices(houseId);
                return ResponseEntity.ok(housedevices);
        }
}
