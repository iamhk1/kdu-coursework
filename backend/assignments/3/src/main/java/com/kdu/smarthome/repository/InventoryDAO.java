package com.kdu.smartHome.repository;

import com.kdu.smartHome.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryDAO extends JpaRepository<Inventory,Long> {

}
