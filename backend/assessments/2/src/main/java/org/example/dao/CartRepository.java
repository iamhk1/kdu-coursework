package org.example.dao;

import org.example.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository  extends JpaRepository<Cart, Long> {
    @Modifying
    @Query("SELECT s FROM Cart s")
    List<Cart> getCart();
    @Modifying
    @Query("UPDATE Cart s SET s.name = ?2 WHERE s.id = ?1")
    int updateCart( Long id, String name);

}
