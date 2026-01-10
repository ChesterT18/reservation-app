package com.caps.reservationapp.response;

import java.io.Serializable;
// import java.time.LocalDate;
// import java.time.LocalDateTime;
// import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;
import java.util.UUID;
import lombok.Data;

@Data
public class ReservationDto implements Serializable {

  private UUID id;
  private UUID userId;
  private String userName;
  private List<UUID> tableIds = new ArrayList<UUID>();
  private List<ResOrderDto> orders = new ArrayList<ResOrderDto>();
  private String date; // LocalDate date;
  private String startTime; // LocalTime time;
  private String endTime;
  private Integer pax;
  private Double totalAmount;
  private String status;
  private String createdAt; // LocalDateTime createdAt;
  private String updatedAt; // LocalDateTime updatedAt;
  private String notes;

}
