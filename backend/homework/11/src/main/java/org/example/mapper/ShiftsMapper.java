package org.example.mapper;

import org.example.models.Shifts;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ShiftsMapper implements RowMapper<Shifts> {
    public Shifts mapRow(ResultSet rs, int rowNum) throws SQLException {
        Shifts shifts = new Shifts();
        shifts.setId(rs.getString("id"));
        shifts.setShiftTypeId(rs.getString("shift_type_id"));
        shifts.setName(rs.getString("name"));
        shifts.setDateStart(rs.getDate("date_start"));
        shifts.setDateEnd(rs.getDate("date_end"));
        shifts.setTimeStart(rs.getTime("time_start"));
        shifts.setTimeEnd(rs.getTime("time_end"));
        shifts.setCreatedAt(rs.getTimestamp("created_at").toInstant());
        shifts.setUpdatedAt(rs.getTimestamp("updated_at").toInstant());
        shifts.setTimeZone(rs.getString("time_zone"));
        shifts.setTenantId(rs.getString("tenant_id"));
        shifts.setCreatedBy(rs.getString("created_by"));
        shifts.setUpdatedBy(rs.getString("updated_by"));
        return shifts;
    }
}
