package org.example.dao;

import org.example.entity.Cart;
import org.example.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    @Modifying
    @Query("UPDATE Inventory s SET s.name = ?2 WHERE s.id = ?1")
    int updateInventory( Long id, String name);
}
