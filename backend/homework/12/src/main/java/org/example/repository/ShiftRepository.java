package org.example.repository;

import org.example.entity.Shift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ShiftRepository extends JpaRepository<Shift, String> {
    @Query("SELECT s FROM Shift s WHERE s.dateStart = :startDate AND s.dateEnd = :endDate ORDER BY s.name ASC LIMIT 3")
    List<Shift> findTop3ShiftsByDateRange(LocalDate startDate, LocalDate endDate);

}
