package org.example.mapper;

import org.example.models.Users;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class UserMapper implements RowMapper<Users> {
    @Override
    public Users mapRow(ResultSet rs, int rowNum)throws SQLException{

        Users users = new Users();
        users.setId(rs.getString("id"));
        users.setUsername(rs.getString("username"));
        users.setLoggedin(rs.getShort("loggedin"));
        users.setTimeZone(rs.getString("time_zone"));
        users.setTenantId(rs.getString("tenant_id"));
        users.setCreatedBy(rs.getString("created_by"));
        users.setUpdatedBy(rs.getString("updated_by"));
        users.setCreatedAt(rs.getTimestamp("created_at").toInstant());
        users.setUpdatedAt(rs.getTimestamp("updated_at").toInstant());
        return users;
    }
}
