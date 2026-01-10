package com.caps.reservationapp.response;

import java.io.Serializable;
import java.util.UUID;
import lombok.Data;

@Data
public class MenuItemDto implements Serializable {

  private UUID id;
  private String name;
  private String description;
  private String category;
  private Double price;
  private String imgUrl;
  private Integer noOfReviews;
  private Double averageRating;
  private Integer perfectRating;

}
