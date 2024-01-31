package org.example.services;

import lombok.extern.slf4j.Slf4j;
import org.example.dao.ShiftDao;
import org.example.dao.ShiftTypeDao;
import org.example.dao.ShiftUserDao;
import org.example.dao.UserDao;
import org.example.dto.*;
import org.example.models.ShiftTypes;
import org.example.models.ShiftUser;
import org.example.models.Shifts;
import org.example.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Slf4j
public class MainService {
    ShiftDao shiftDao;
    ShiftUserDao shiftUserDao;
    ShiftTypeDao shiftTypeDao;
    UserDao userDao;
    @Autowired
    public MainService(ShiftDao shiftDao,ShiftUserDao shiftUserDao,ShiftTypeDao shiftTypeDao,UserDao userDao){
        this.shiftDao=shiftDao;
        this.shiftUserDao=shiftUserDao;
        this.shiftTypeDao=shiftTypeDao;
        this.userDao=userDao;
    }

    public void addNewUser(UsersDTO user)
    {
        Instant createdAt = Instant.now();
        Instant updatedAt=Instant.now();
        Users userObj=new Users(user.getUsername(),user.getLoggedin(),user.getTimeZone(),user.getTenantId(),user.getCreatedBy(),user.getUpdatedBy(),createdAt,updatedAt);
        userDao.addUser(userObj);

    }
    public void addShiftUser(ShiftUserDTO shiftUserDTO)
    {
        Instant createdAt = Instant.now();
        Instant updatedAt=Instant.now();
        ShiftUser newShiftUser=new ShiftUser(shiftUserDTO.getShiftId(),shiftUserDTO.getUserId(),shiftUserDTO.getTenantId(),shiftUserDTO.getCreatedBy(),shiftUserDTO.getUpdatedBy(),createdAt,updatedAt);
        shiftUserDao.addShiftUser(newShiftUser);
    }
    public void addShiftType(ShiftTypesDTO shiftTypesDTO)
    {
        Instant createdAt = Instant.now();
        Instant updatedAt=Instant.now();
        ShiftTypes newShiftType=new ShiftTypes(shiftTypesDTO.getUqName(),shiftTypesDTO.getDescription(),shiftTypesDTO.getActive(),createdAt,updatedAt,shiftTypesDTO.getTimeZone(),shiftTypesDTO.getTenantId(),shiftTypesDTO.getCreatedBy(),shiftTypesDTO.getUpdatedBy());
        shiftTypeDao.addShiftTypeUser(newShiftType);
    }
    public void addShift(ShiftsDTO shiftsDTO)
    {
        Instant createdAt = Instant.now();
        Instant updatedAt=Instant.now();
        Shifts newShifts=new Shifts(shiftsDTO.getShiftTypeId(),shiftsDTO.getName(),shiftsDTO.getDateStart(),shiftsDTO.getDateEnd(),shiftsDTO.getTimeStart(),shiftsDTO.getTimeEnd(),createdAt,updatedAt,shiftsDTO.getTimeZone(),shiftsDTO.getTenantId(),shiftsDTO.getCreatedBy(),shiftsDTO.getUpdatedBy());
        shiftDao.addShiftUser(newShifts);
    }
    public void addAll(AllDTO allDTO)
    {
        Instant createdAt = Instant.now();
        Instant updatedAt=Instant.now();
        Users userObj=new Users(allDTO.getUsername(),allDTO.getLoggedin(),allDTO.getTimeZone(),allDTO.getTenantId(),allDTO.getCreatedBy(),allDTO.getUpdatedBy(),createdAt,updatedAt);
        userDao.addUser(userObj);
        ShiftTypes newShiftType=new ShiftTypes(allDTO.getUqName(),allDTO.getDescription(),allDTO.getActive(),createdAt,updatedAt,allDTO.getTimeZone(),allDTO.getTenantId(),allDTO.getCreatedBy(),allDTO.getUpdatedBy());
        shiftTypeDao.addShiftTypeUser(newShiftType);
        Shifts newShifts=new Shifts(newShiftType.getId(),allDTO.getName(),allDTO.getDateStart(),allDTO.getDateEnd(),allDTO.getTimeStart(),allDTO.getTimeEnd(),createdAt,updatedAt,allDTO.getTimeZone(),allDTO.getTenantId(),allDTO.getCreatedBy(),allDTO.getUpdatedBy());
        shiftDao.addShiftUser(newShifts);
        ShiftUser newShiftUser=new ShiftUser(newShifts.getId(),userObj.getId(),allDTO.getTenantId(),allDTO.getCreatedBy(),allDTO.getUpdatedBy(),createdAt,updatedAt);
        shiftUserDao.addShiftUser(newShiftUser);
    }

    public UsersDTO getUser(String tenantId)
    {
        Users user=userDao.getUser(tenantId);
        return new UsersDTO(user.getUsername(),user.getLoggedin(),user.getTimeZone(),user.getTenantId(),user.getUpdatedBy(),user.getCreatedBy());
    }
    public ShiftUserDTO getShiftUser(String tenantId)
    {
        ShiftUser shiftUser=shiftUserDao.getShiftUser(tenantId);
        return new ShiftUserDTO(shiftUser.getShiftId(),shiftUser.getUserId(),shiftUser.getTenantId(),shiftUser.getCreatedBy(),shiftUser.getUpdatedBy());
    }
    public ShiftTypesDTO getShiftType(String tenantId)
    {
        ShiftTypes shiftTypes=shiftTypeDao.getShiftType(tenantId);
        return new ShiftTypesDTO(shiftTypes.getUqName(),shiftTypes.getDescription(),shiftTypes.getActive(),shiftTypes.getTimeZone(),shiftTypes.getTenantId(),shiftTypes.getCreatedBy(),shiftTypes.getUpdatedBy());
    }
    public ShiftsDTO getShift(String tenantId)
    {
        Shifts shifts=shiftDao.getShift(tenantId);
        return new ShiftsDTO(shifts.getShiftTypeId(),shifts.getName(),shifts.getDateStart(),shifts.getDateEnd(),shifts.getTimeStart(),shifts.getTimeEnd(),shifts.getTimeZone(),shifts.getTenantId(),shifts.getCreatedBy(),shifts.getUpdatedBy());
    }
    public void updateUser(Users user)
    {
        log.info("At service");
        userDao.updateUser(user);
    }
}
