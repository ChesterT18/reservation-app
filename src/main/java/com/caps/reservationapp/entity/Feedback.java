package com.caps.reservationapp.entity;

import java.io.Serializable;
import java.util.UUID;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "feedbacks")
@Data
public class Feedback implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id")
  private UUID id;

  @Column(name = "user_id")
  private UUID userId;

  @Column(name = "user_name")
  private String userName;

  @Column(name = "reservation_id")
  private UUID reservationId;

  @Column(name = "food_quality_rating")
  private Integer foodQualityRating;

  @Column(name = "food_quality_comment")
  private String foodQualityComment;

  @Column(name = "service_rating")
  private Integer serviceRating;

  @Column(name = "service_comment")
  private String serviceComment;

  @Column(name = "ambiance_rating")
  private Integer ambianceRating;

  @Column(name = "ambiance_comment")
  private String ambianceComment;

  @Column(name = "cleanliness_rating")
  private Integer cleanlinessRating;

  @Column(name = "cleanliness_comment")
  private String cleanlinessComment;

  @Column(name = "value_for_money_rating")
  private Integer valueForMoneyRating;

  @Column(name = "value_for_money_comment")
  private String valueForMoneyComment;

  @Column(name = "overall_rating")
  private String overallRating;

  @Column(name = "general_feedback")
  private String generalFeedback;

  @Column(name = "suggestion")
  private String suggestion;

  @Column(name = "recommend")
  private String recommend;

  @Column(name = "favorite_food_ids")
  private String favoriteFoodIds;

  @Column(name = "created_at")
  private String createdAt;

}