package com.kdu.smartHome.repository;

import com.kdu.smartHome.model.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomDAO extends JpaRepository<Rooms,Long> {

}
