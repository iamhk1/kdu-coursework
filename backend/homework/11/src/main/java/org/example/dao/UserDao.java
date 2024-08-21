package org.example.dao;

import lombok.extern.slf4j.Slf4j;

import org.example.exceptions.custom.GetException;
import org.example.mapper.UserMapper;
import org.example.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@Slf4j
public class UserDao {
        final JdbcTemplate jdbcTemplate;
        @Autowired
        public UserDao(JdbcTemplate jdbcTemplate)
        {
            this.jdbcTemplate=jdbcTemplate;
        }
        public void addUser(Users user)
        {
            UUID uuid = UUID.randomUUID();
            String uuidString = uuid.toString();
            user.setId(uuidString);
            String sql="INSERT INTO users (id,username,loggedin,time_zone,tenant_id,created_by,updated_by,created_at,updated_at)"+
                    "VALUES(UUID_TO_BIN(?),?,?,?,UUID_TO_BIN(?),?,?,?,?)";
            try {
                jdbcTemplate.update(sql, uuidString, user.getUsername(), user.getLoggedin(), user.getTimeZone(), user.getTenantId(), user.getCreatedBy(), user.getUpdatedBy(), user.getCreatedAt(), user.getUpdatedAt());
            }
            catch(Exception e)
            {
                throw new GetException(e.getMessage());
            }
        }
        public Users getUser(String tenantId)
        {

            String sql="SELECT *FROM users WHERE tenant_id=UUID_TO_BIN(?)";
            try {
                return jdbcTemplate.queryForObject(sql,new UserMapper(),tenantId);
            }
            catch (Exception e)
            {
                throw new GetException(e.getMessage());
            }

        }
        public void updateUser(Users user)
        {
           try {
               jdbcTemplate.update("UPDATE users SET loggedin=?, time_zone=?, tenant_id=UUID_TO_BIN(?), created_by=?, updated_by=?, created_at=?, updated_at=? WHERE username=?",
                       user.getLoggedin(), user.getTimeZone(), user.getTenantId(), user.getCreatedBy(), user.getUpdatedBy(), user.getCreatedAt(), user.getUpdatedAt(), user.getUsername());
           }
           catch (Exception e)
           {
               throw new GetException(e.getMessage());
           }
        }
}
