package com.caps.reservationapp.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.caps.reservationapp.entity.MenuItem;

public interface MenuItemRepo extends JpaRepository<MenuItem, UUID> {

  @Query("SELECT m FROM MenuItem m WHERE m.id = :id")
  Optional<MenuItem> findById(@Param("id") UUID id);

  // @Query("SELECT m FROM MenuItem m")
  // List<MenuItem> findAll();

}