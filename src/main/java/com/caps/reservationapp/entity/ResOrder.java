package com.caps.reservationapp.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "orders")
@Data
public class ResOrder implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id")
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "reservation_id", nullable = false)
  @JsonIgnore
  private Reservation reservation;

  @Column(name = "food_id")
  private UUID foodId;

  @Column(name = "food_name")
  private String foodName;

  @Column(name = "single_amount")
  private Double singleAmount;

  @Column(name = "number")
  private Integer number;

  @Column(name = "size")
  private String size;

  @Column(name = "variation")
  private String variation;

  @Column(name = "instructions")
  private String instructions;

}
