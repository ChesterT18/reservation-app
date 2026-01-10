package com.caps.reservationapp.entity;

import java.io.Serializable;
import java.util.UUID;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tables")
@Data
public class DineTable implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id")
  private UUID id;

  @Column(name = "name")
  private String name;

  @Column(name = "available_seats")
  private Integer availableSeats;

  @Column(name = "category")
  private String category;

  @Column(name = "hourly_cost")
  private Double hourlyCost;

}
