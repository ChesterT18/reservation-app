package com.caps.reservationapp.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.caps.reservationapp.entity.Feedback;

public interface FeedbackRepo extends JpaRepository<Feedback, UUID> {

  @Query("SELECT m FROM Feedback m WHERE m.id = :id")
  Optional<Feedback> findById(@Param("id") UUID id);

}