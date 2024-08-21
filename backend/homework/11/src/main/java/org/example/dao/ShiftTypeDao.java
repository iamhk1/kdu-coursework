package org.example.dao;


import org.example.exceptions.custom.GetException;
import org.example.mapper.ShiftTypesMapper;

import org.example.models.ShiftTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class ShiftTypeDao {
    final JdbcTemplate jdbcTemplate;
    @Autowired
    public ShiftTypeDao(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate=jdbcTemplate;
    }
    public void addShiftTypeUser(ShiftTypes shiftTypesUser)
    {
        UUID uuid = UUID.randomUUID();
        String uuidString = uuid.toString();
        shiftTypesUser.setId(uuidString);
        String sql="INSERT INTO shift_types(id,uq_name,description,active,created_at,updated_at,time_zone,tenant_id,created_by,updated_by)"+
                "VALUES(UUID_TO_BIN(?),?,?,?,?,?,?,UUID_TO_BIN(?),?,?)";
        try {
            jdbcTemplate.update(sql, uuidString, shiftTypesUser.getUqName(), shiftTypesUser.getDescription(), shiftTypesUser.getActive()
                    , shiftTypesUser.getCreatedAt(), shiftTypesUser.getUpdatedAt(), shiftTypesUser.getTimeZone(), shiftTypesUser.getTenantId()
                    , shiftTypesUser.getCreatedBy(), shiftTypesUser.getUpdatedBy());
        }
        catch (Exception e)
        {
            throw new GetException(e.getMessage());
        }
    }
    public ShiftTypes getShiftType(String tenantId)
    {
        String sql="SELECT *FROM shift_types WHERE tenant_id=UUID_TO_BIN(?)";
        try {
            return jdbcTemplate.queryForObject(sql, new ShiftTypesMapper(), tenantId);
        }
        catch (Exception e)
        {
            throw new GetException(e.getMessage());
        }
    }

}
