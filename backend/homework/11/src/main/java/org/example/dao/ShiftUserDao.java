package org.example.dao;


import org.example.exceptions.custom.GetException;
import org.example.mapper.ShiftUserMapper;
import org.example.models.ShiftUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class ShiftUserDao {
    final JdbcTemplate jdbcTemplate;
    @Autowired
    public ShiftUserDao(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate=jdbcTemplate;
    }
    public void addShiftUser(ShiftUser shiftUser)
    {
        UUID uuid = UUID.randomUUID();
        String uuidString = uuid.toString();
        shiftUser.setId(uuidString);
        String sql="INSERT INTO shift_user(id,shift_id,user_id,tenant_id,created_by,updated_by,created_at,updated_at)"+
                "VALUES(UUID_TO_BIN(?),UUID_TO_BIN(?),UUID_TO_BIN(?),UUID_TO_BIN(?),?,?,?,?)";
        try {
            jdbcTemplate.update(sql, uuidString, shiftUser.getShiftId(), shiftUser.getUserId(), shiftUser.getTenantId(), shiftUser.getCreatedBy(), shiftUser.getUpdatedBy(), shiftUser.getCreatedAt(), shiftUser.getUpdatedAt());
        }
        catch (Exception e)
        {
            throw new GetException(e.getMessage());
        }

        }
    public ShiftUser getShiftUser(String tenantId)
    {

        String sql="SELECT *FROM shift_user WHERE tenant_id=UUID_TO_BIN(?)";
        try {
            return jdbcTemplate.queryForObject(sql, new ShiftUserMapper(), tenantId);
        }
        catch (Exception e)
        {
            throw new GetException(e.getMessage());
        }
    }
}
