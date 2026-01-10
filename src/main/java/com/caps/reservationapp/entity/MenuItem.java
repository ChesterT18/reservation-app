package com.caps.reservationapp.entity;

import java.io.Serializable;
import java.util.UUID;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "menu")
@Data
public class MenuItem implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id")
  private UUID id;

  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;

  @Column(name = "category")
  private String category;

  @Column(name = "price")
  private Double price;

  @Column(name = "img_url")
  private String imgUrl;

  @Column(name = "no_of_reviews")
  private Integer noOfReviews;

  @Column(name = "average_rating")
  private Double averageRating;

  @Column(name = "perfect_rating")
  private Integer perfectRating;

}
