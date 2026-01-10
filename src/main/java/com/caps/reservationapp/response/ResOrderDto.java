package com.caps.reservationapp.response;

import java.io.Serializable;
import java.util.UUID;
import lombok.Data;

@Data
public class ResOrderDto implements Serializable {

  private UUID id;
  private UUID reservationId;
  private UUID foodId;
  private String foodName;
  private Double singleAmount;
  private Integer number;
  private String size;
  private String variation;
  private String instructions;

}
