package com.caps.reservationapp.mapper;

import java.util.List;
import org.mapstruct.Mapper;

import com.caps.reservationapp.response.ResOrderDto;
import com.caps.reservationapp.entity.ResOrder;
import com.caps.reservationapp.entity.Reservation;

@Mapper(componentModel = "spring")
public interface ResOrderMapper {

  ResOrderDto toResOrderDto(ResOrder resOrder, Reservation reservation);
  ResOrder toResOrderEntity(ResOrderDto resOrderDto, Reservation reservation);
  List<ResOrderDto> toResOrderDtoList(List<ResOrder> resOrders, Reservation reservation);
  List<ResOrder> toResOrderEntityList(List<ResOrderDto> resOrderDtos, Reservation reservation);
  
}
