package com.caps.reservationapp.mapper;

import java.util.List;
import org.mapstruct.Mapper;

import com.caps.reservationapp.response.ReservationDto;
import com.caps.reservationapp.entity.Reservation;

@Mapper(componentModel = "spring")
public interface ReservationMapper {

  ReservationDto toReservationDto(Reservation reservation);
  Reservation toReservationEntity(ReservationDto reservationDto);
  List<ReservationDto> toReservationDtoList(List<Reservation> reservations);
  List<Reservation> toReservationEntityList(List<ReservationDto> reservationDtos);
  
}
