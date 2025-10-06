package com.caps.reservationapp.response;

import java.io.Serializable;
import lombok.Data;

@Data
public class MenuItemResponse implements Serializable {

  private Integer id;
  private String name;
  private String mealTime;
  private String category;
  private Double price;
  private Integer noOfReviews;
  private Double averageRating;
  private Integer perfectRating;

}
