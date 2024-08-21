package org.example.mapper;

import org.example.models.ShiftUser;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ShiftUserMapper implements RowMapper<ShiftUser> {

    @Override
    public ShiftUser mapRow(ResultSet rs, int rowNum) throws SQLException {
        ShiftUser shiftUser = new ShiftUser();
        shiftUser.setShiftId(rs.getString("shift_id"));
        shiftUser.setUserId(rs.getString("user_id"));
        shiftUser.setTenantId(rs.getString("tenant_id"));
        shiftUser.setCreatedBy(rs.getString("created_by"));
        shiftUser.setUpdatedBy(rs.getString("updated_by"));
        shiftUser.setCreatedAt(rs.getTimestamp("created_at").toInstant());
        shiftUser.setUpdatedAt(rs.getTimestamp("updated_at").toInstant());
        return shiftUser;
    }
}
