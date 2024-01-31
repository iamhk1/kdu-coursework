package org.example.dao;

import org.example.exceptions.custom.GetException;
import org.example.mapper.ShiftsMapper;
import org.example.models.Shifts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Repository
public class ShiftDao {
    final JdbcTemplate jdbcTemplate;
    @Autowired
    public ShiftDao(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate=jdbcTemplate;
    }
    public void addShiftUser(Shifts shift)
    {
        String dateStart = shift.getDateStart().toString();
        String dateEnd=shift.getDateEnd().toString();
        String timeStart =shift.getTimeStart().toString();
        String timeEnd=shift.getTimeEnd().toString();

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        LocalDate dateSt = LocalDate.parse(dateStart, dateFormatter);
        LocalDate dateEd=LocalDate.parse(dateEnd,dateFormatter);
        LocalTime timeSt = LocalTime.parse(timeStart, timeFormatter);
        LocalTime timeEd= LocalTime.parse(timeEnd, timeFormatter);
        UUID uuid = UUID.randomUUID();
        String uuidString = uuid.toString();
        shift.setId(uuidString);
        String sql="INSERT INTO shifts (id,shift_type_id,name,date_start,date_end,time_start,time_end,created_at,updated_at,time_zone,tenant_id,created_by,updated_by)"+
                "VALUES(UUID_TO_BIN(?),UUID_TO_BIN(?),?,?,?,?,?,?,?,?,UUID_TO_BIN(?),?,?)";
        try {
            jdbcTemplate.update(sql, uuidString, shift.getShiftTypeId(), shift.getName(), dateSt, dateEd, timeSt, timeEd, shift.getCreatedAt(), shift.getUpdatedAt(), shift.getTimeZone(), shift.getTenantId(), shift.getCreatedBy(), shift.getUpdatedBy());
        }
        catch (Exception e)
        {
            throw new GetException(e.getMessage());
        }

    }
    public Shifts getShift(String tenantId)
    {
        String sql="SELECT *FROM shifts WHERE tenant_id=UUID_TO_BIN(?)";

        try {
            return jdbcTemplate.queryForObject(sql,new ShiftsMapper(),tenantId);
        }
        catch (Exception e)
        {
            throw new GetException(e.getMessage());
        }

    }
}
