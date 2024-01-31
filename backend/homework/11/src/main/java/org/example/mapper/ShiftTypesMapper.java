package org.example.mapper;

import org.example.models.ShiftTypes;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ShiftTypesMapper implements RowMapper<ShiftTypes> {

        @Override
        public ShiftTypes mapRow(ResultSet rs, int rowNum) throws SQLException {
            ShiftTypes shiftTypes = new ShiftTypes();
            shiftTypes.setId(rs.getString("id"));
            shiftTypes.setUqName(rs.getString("uq_name"));
            shiftTypes.setDescription(rs.getString("description"));
            shiftTypes.setActive(rs.getBoolean("active"));
            shiftTypes.setCreatedAt(rs.getTimestamp("created_at").toInstant());
            shiftTypes.setUpdatedAt(rs.getTimestamp("updated_at").toInstant());
            shiftTypes.setTimeZone(rs.getString("time_zone"));
            shiftTypes.setTenantId(rs.getString("tenant_id"));
            shiftTypes.setCreatedBy(rs.getString("created_by"));
            shiftTypes.setUpdatedBy(rs.getString("updated_by"));
            return shiftTypes;
        }
    }

