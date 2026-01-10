package com.caps.reservationapp.mapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.caps.reservationapp.response.FeedbackDto;
import com.caps.reservationapp.entity.Feedback;

public class FeedbackMapperImpl implements FeedbackMapper {

  @Override
  public FeedbackDto toDto(Feedback entity) {
    if (entity == null) {
      return null;
    }

    FeedbackDto dto = new FeedbackDto();
    dto.setId(entity.getId());
    dto.setUserId(entity.getUserId());
    dto.setReservationId(entity.getReservationId());
    dto.setFoodQualityRating(entity.getFoodQualityRating());
    dto.setFoodQualityComment(entity.getFoodQualityComment());
    dto.setServiceRating(entity.getServiceRating());
    dto.setServiceComment(entity.getServiceComment());
    dto.setAmbianceRating(entity.getAmbianceRating());
    dto.setAmbianceComment(entity.getAmbianceComment());
    dto.setCleanlinessRating(entity.getCleanlinessRating());
    dto.setCleanlinessComment(entity.getCleanlinessComment());
    dto.setGeneralFeedback(entity.getGeneralFeedback());
    dto.setSuggestion(entity.getSuggestion());
    dto.setRecommend(entity.getRecommend());
    dto.setCreatedAt(entity.getCreatedAt());

    // for (String foodId : Arrays.asList(entity.getFavoriteFoodIds().split(","))) {
    //   dto.getFavoriteFoodIds().add(UUID.fromString((foodId)));
    // }
    return dto;

  }

  @Override
  public Feedback toEntity(FeedbackDto dto) {
    if (dto == null) {
      return null;
    }
    Feedback entity = new Feedback();
    if (dto.getId() != null) {
      entity.setId(dto.getId());
    }
    entity.setUserId(dto.getUserId());
    entity.setReservationId(dto.getReservationId());
    entity.setFoodQualityRating(dto.getFoodQualityRating());
    entity.setFoodQualityComment(dto.getFoodQualityComment());
    entity.setServiceRating(dto.getServiceRating());
    entity.setServiceComment(dto.getServiceComment());
    entity.setAmbianceRating(dto.getAmbianceRating());
    entity.setAmbianceComment(dto.getAmbianceComment());
    entity.setCleanlinessRating(dto.getCleanlinessRating());
    entity.setCleanlinessComment(dto.getCleanlinessComment());
    entity.setGeneralFeedback(dto.getGeneralFeedback());
    entity.setSuggestion(dto.getSuggestion());
    entity.setRecommend(dto.getRecommend());
    entity.setCreatedAt(dto.getCreatedAt());

    // entity.setFavoriteFoodIds(String.join(",", dto.getFavoriteFoodIds().stream().map(UUID::toString).collect(Collectors.toList())));

    return entity;
  }

  @Override
  public List<FeedbackDto> toDtos(List<Feedback> entities) {
    if (entities == null | entities.isEmpty()) {
      return new ArrayList<FeedbackDto>();
    }
    List<FeedbackDto> dtos = new ArrayList<FeedbackDto>();
    for (Feedback entity : entities) {
      dtos.add(toDto(entity));
    }
    return dtos;
  }

  @Override
  public List<Feedback> toEntities(List<FeedbackDto> dtos) {
    if (dtos == null | dtos.isEmpty()) {
      return new ArrayList<Feedback>();
    }
    List<Feedback> entities = new ArrayList<Feedback>();
    for (FeedbackDto dto : dtos) {
      entities.add(toEntity(dto));
    }
    return entities;
  }
  
}
