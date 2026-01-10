package com.caps.reservationapp.entity;

import java.io.Serializable;
import java.util.UUID;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ratings")
@Data
public class UserRating implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id")
  private UUID id;

  @Column(name = "user_id")
  private UUID userId;

  @Column(name = "user_name")
  private String userName;

  @Column(name = "food_id")
  private UUID foodId;

  @Column(name = "score")
  private Integer score;
  
  @Column(name = "created_at")
  private String createdAt;

}