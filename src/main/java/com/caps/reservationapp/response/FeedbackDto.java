package com.caps.reservationapp.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.Data;

@Data
public class FeedbackDto implements Serializable {

  private UUID id;
  private UUID userId;
  private String userName;
  private UUID reservationId;
  private Integer foodQualityRating;
  private String foodQualityComment;
  private Integer serviceRating;
  private String serviceComment;
  private Integer ambianceRating;
  private String ambianceComment;
  private Integer cleanlinessRating;
  private String cleanlinessComment;
  private String generalFeedback;
  private String suggestion;
  private String recommend;
  private String favoriteFoodIds;
  private String createdAt;

}
