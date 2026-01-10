package com.caps.reservationapp.repository;

// import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.caps.reservationapp.entity.DineTable;

public interface DineTableRepo extends JpaRepository<DineTable, UUID> {

  @Query("SELECT m FROM DineTable m WHERE m.id = :id")
  Optional<DineTable> findById(@Param("id") UUID id);

  // @Query("SELECT m FROM DineTable m")
  // List<DineTable> findAll();

}