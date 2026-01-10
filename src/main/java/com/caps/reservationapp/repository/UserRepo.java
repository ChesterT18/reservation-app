package com.caps.reservationapp.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.caps.reservationapp.entity.User;

public interface UserRepo extends JpaRepository<User, UUID> {

  @Query("SELECT m FROM User m WHERE m.email = :email AND m.password = :password")
  Optional<User> findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

}