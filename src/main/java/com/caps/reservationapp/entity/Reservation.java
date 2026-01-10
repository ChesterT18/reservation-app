package com.caps.reservationapp.entity;

import java.io.Serializable;
import java.util.ArrayList;
// import java.time.LocalDate;
// import java.time.LocalDateTime;
// import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "reservations")
@Data
public class Reservation implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id")
  private UUID id;

  @Column(name = "user_id")
  private UUID userId;

  @Column(name = "user_name")
  private String userName;

  @Column(name = "table_ids")
  private String tableIds;

  @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
  private List<ResOrder> orders = new ArrayList<ResOrder>();

  @Column(name = "date")
  // private LocalDate date;
  private String date;

  @Column(name = "start_time")
  // private LocalTime time;
  private String startTime;

  @Column(name = "end_time")
  private String endTime;

  @Column(name = "pax")
  private Integer pax;

  @Column(name = "total_amount")
  private Double totalAmount;

  @Column(name = "status")
  private String status;

  @Column(name = "created_at")
  // private LocalDateTime createdAt;
  private String createdAt;

  @Column(name = "updated_at")
  // private LocalDateTime updatedAt;
  private String updatedAt;

  @Column(name = "notes")
  private String notes;

}
