package org.example.repository;

import org.example.entity.ShiftType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShiftTypeRepository extends JpaRepository<ShiftType, String> {
}
