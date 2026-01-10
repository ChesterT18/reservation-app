package com.caps.reservationapp.response;

import java.io.Serializable;
import java.util.UUID;
import lombok.Data;

@Data
public class DineTableDto implements Serializable {

  private UUID id;
  private String name;
  private Integer availableSeats;
  private String category;
  private Double hourlyCost;

}
