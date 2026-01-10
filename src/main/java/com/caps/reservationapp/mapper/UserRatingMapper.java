package com.caps.reservationapp.mapper;

import java.util.List;
import org.mapstruct.Mapper;

import com.caps.reservationapp.response.UserRatingDto;
import com.caps.reservationapp.entity.UserRating;

@Mapper(componentModel = "spring")
public interface UserRatingMapper {

  UserRatingDto toReservationDto(UserRating userRating);
  UserRating toReservationEntity(UserRatingDto userRatingDto);
  List<UserRatingDto> toReservationDtoList(List<UserRating> userRatings);
  List<UserRating> toReservationEntityList(List<UserRatingDto> userRatingDtos);
  
}
