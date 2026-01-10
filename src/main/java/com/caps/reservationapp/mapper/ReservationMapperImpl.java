package com.caps.reservationapp.mapper;

// import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.caps.reservationapp.response.ResOrderDto;
import com.caps.reservationapp.response.ReservationDto;
import com.caps.reservationapp.entity.ResOrder;
import com.caps.reservationapp.entity.Reservation;

public class ReservationMapperImpl implements ReservationMapper, ResOrderMapper {

  @Override
  public ResOrderDto toResOrderDto(ResOrder entity, Reservation reservation) {
    if (entity == null) {
      return null;
    }
    ResOrderDto dto = new ResOrderDto();
    dto.setId(entity.getId());
    if (reservation != null) {
      dto.setReservationId(reservation.getId());
    }
    dto.setFoodId(entity.getFoodId());
    dto.setFoodName(entity.getFoodName());
    dto.setSingleAmount(entity.getSingleAmount());
    dto.setNumber(entity.getNumber());
    dto.setSize(entity.getSize());
    dto.setVariation(entity.getVariation());
    dto.setInstructions(entity.getInstructions());
    return dto;
  }

  @Override
  public ResOrder toResOrderEntity(ResOrderDto dto, Reservation reservation) {
    if (dto == null) {
      return null;
    }
    ResOrder entity = new ResOrder();
    if (dto.getId() != null) {
      entity.setId(dto.getId());
    }
    entity.setReservation(reservation);
    entity.setFoodId(dto.getFoodId());
    entity.setFoodName(dto.getFoodName());
    entity.setSingleAmount(dto.getSingleAmount());
    entity.setNumber(dto.getNumber());
    entity.setSize(dto.getSize());
    entity.setVariation(dto.getVariation());
    entity.setInstructions(dto.getInstructions());
    return entity;
  }

  @Override
  public List<ResOrderDto> toResOrderDtoList(List<ResOrder> entities, Reservation reservation) {
    if (entities == null | entities.isEmpty()) {
      return new ArrayList<ResOrderDto>();
    }
    List<ResOrderDto> dtos = new ArrayList<ResOrderDto>();
    for (ResOrder entity : entities) {
      dtos.add(toResOrderDto(entity, reservation));
    }
    return dtos;
  }

  @Override
  public List<ResOrder> toResOrderEntityList(List<ResOrderDto> dtos, Reservation reservation) {
    if (dtos == null | dtos.isEmpty()) {
      return new ArrayList<ResOrder>();
    }
    List<ResOrder> entities = new ArrayList<ResOrder>();
    for (ResOrderDto dto : dtos) {
      entities.add(toResOrderEntity(dto, reservation));
    }
    return entities;
  }

  @Override
  public ReservationDto toReservationDto(Reservation entity) {
    if (entity == null) {
      return null;
    }
    ReservationDto dto = new ReservationDto();
    dto.setId(entity.getId());
    dto.setUserId(entity.getUserId());
    dto.setUserName(entity.getUserName());
   
    for (String tableId : Arrays.asList(entity.getTableIds().split(","))) {
      dto.getTableIds().add(UUID.fromString((tableId)));
    }
    for (ResOrder order : entity.getOrders()) {
      dto.getOrders().add(toResOrderDto(order, entity));
    }
    
    dto.setDate(entity.getDate());
    dto.setStartTime(entity.getStartTime());
    dto.setEndTime(entity.getEndTime());
    dto.setPax(entity.getPax());
    dto.setTotalAmount(entity.getTotalAmount());
    dto.setStatus(entity.getStatus());
    dto.setCreatedAt(entity.getCreatedAt());
    dto.setUpdatedAt(entity.getUpdatedAt());
    dto.setNotes(entity.getNotes());
    return dto;
  }

  @Override
  public Reservation toReservationEntity(ReservationDto dto) {
    if (dto == null) {
      return null;
    }
    Reservation entity = new Reservation();
    if (dto.getId() != null) {
      entity.setId(dto.getId());
    }
    entity.setUserId(dto.getUserId());
    entity.setUserName(dto.getUserName());
    entity.setTableIds(String.join(",", dto.getTableIds().stream().map(UUID::toString).collect(Collectors.toList())));
    entity.setDate(dto.getDate());
    entity.setStartTime(dto.getStartTime());
    entity.setEndTime(dto.getEndTime());
    entity.setPax(dto.getPax());

    Double totalAmount = 0.0;
    for (ResOrderDto orderDto : dto.getOrders()) {
      totalAmount += orderDto.getSingleAmount() * orderDto.getNumber();
    }
    entity.setTotalAmount(totalAmount);

    entity.setStatus(dto.getStatus());
    entity.setCreatedAt(dto.getCreatedAt());
    entity.setUpdatedAt(dto.getUpdatedAt());
    entity.setNotes(dto.getNotes());
    return entity;
  }

  @Override
  public List<ReservationDto> toReservationDtoList(List<Reservation> entities) {
    if (entities == null | entities.isEmpty()) {
      return new ArrayList<ReservationDto>();
    }
    List<ReservationDto> dtos = new ArrayList<ReservationDto>();
    for (Reservation entity : entities) {
      dtos.add(toReservationDto(entity));
    }
    return dtos;
  }

  @Override
  public List<Reservation> toReservationEntityList(List<ReservationDto> dtos) {
    if (dtos == null | dtos.isEmpty()) {
      return new ArrayList<Reservation>();
    }
    List<Reservation> entities = new ArrayList<Reservation>();
    for (ReservationDto dto : dtos) {
      entities.add(toReservationEntity(dto));
    }
    return entities;
  }
  
}
