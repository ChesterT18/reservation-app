package com.caps.reservationapp.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.caps.reservationapp.entity.UserRating;

public interface UserRatingRepo extends JpaRepository<UserRating, UUID> {

  @Query("SELECT m FROM UserRating m WHERE m.id = :id")
  Optional<UserRating> findById(@Param("id") UUID id);

}