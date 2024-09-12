package com.kdu.smartHome.repository;
import com.kdu.smartHome.model.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseDAO extends JpaRepository<House,Long> {

}
