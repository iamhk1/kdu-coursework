package com.kdu.smartHome.repository;

import com.kdu.smartHome.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersDAO extends JpaRepository<User, String> {
    User findByUsername(String username);
}
