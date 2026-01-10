package com.caps.reservationapp.mapper;

import java.util.List;
import org.mapstruct.Mapper;

import com.caps.reservationapp.response.FeedbackDto;
import com.caps.reservationapp.entity.Feedback;

@Mapper(componentModel = "spring")
public interface FeedbackMapper {

  FeedbackDto toDto(Feedback feedback);
  Feedback toEntity(FeedbackDto feedbackDto);
  List<FeedbackDto> toDtos(List<Feedback> feedbacks);
  List<Feedback> toEntities(List<FeedbackDto> feedbackDtos);
  
}
