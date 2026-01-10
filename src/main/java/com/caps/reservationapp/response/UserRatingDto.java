package com.caps.reservationapp.response;

import java.io.Serializable;
import java.util.UUID;
import lombok.Data;

@Data
public class UserRatingDto implements Serializable {

  private UUID id;
  private UUID userId;
  private String userName;
  private UUID foodId;
  private Integer score;
  private String createdAt;

}
