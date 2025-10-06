package com.caps.reservationapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.caps.reservationapp.entity.MenuItem;

public interface MenuItemRepo extends JpaRepository<MenuItem, Integer> {

  @Query("SELECT m FROM MenuItem m WHERE m.id = :id")
  Optional<MenuItem> findById(@Param("id") Integer id);

  @Query("SELECT m FROM MenuItem m")
  List<MenuItem> findAll();

}