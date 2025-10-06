package com.caps.reservationapp.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "menu")
@Data
public class MenuItem implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Column(name = "name")
  private String name;

  @Column(name = "meal_time")
  private String mealTime;

  @Column(name = "category")
  private String category;

  @Column(name = "price")
  private Double price;

  @Column(name = "no_of_reviews")
  private Integer noOfReviews;

  @Column(name = "average_rating")
  private Double averageRating;

  @Column(name = "perfect_rating")
  private Integer perfectRating;

}
