package com.caps.reservationapp.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.caps.reservationapp.entity.Reservation;

public interface ReservationRepo extends JpaRepository<Reservation, UUID> {

  @Query("SELECT m FROM Reservation m WHERE m.id = :id")
  @EntityGraph(attributePaths = "orders")
  Optional<Reservation> findById(@Param("id") UUID id);

  @Query("SELECT m FROM Reservation m WHERE m.userId = :userId")
  @EntityGraph(attributePaths = "orders")
  List<Reservation> findByUserId(@Param("userId") UUID userId);

  @Query("SELECT m FROM Reservation m WHERE m.date = :date")
  List<Reservation> findByDate(@Param("date") String date);

  @Query("SELECT m FROM Reservation m WHERE LOCATE(:tableId, m.tableIds) > 0")
  List<Reservation> findByTableId(@Param("tableId") String tableId);

  @Query("SELECT m FROM Reservation m WHERE m.date = :date AND LOCATE(:tableId, m.tableIds) > 0")
  List<Reservation> findByDateAndTableId(@Param("date") String date, @Param("tableId") String tableId);

  @Query("SELECT m FROM Reservation m")
  @EntityGraph(attributePaths = "orders")
  List<Reservation> findAll();

}