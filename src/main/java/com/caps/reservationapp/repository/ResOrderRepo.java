package com.caps.reservationapp.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.caps.reservationapp.entity.ResOrder;

public interface ResOrderRepo extends JpaRepository<ResOrder, UUID> {

  @Query("SELECT m FROM ResOrder m WHERE m.id = :id")
  Optional<ResOrder> findById(@Param("id") UUID id);

}