package com.caps.reservationapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
import java.util.UUID;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import jakarta.transaction.Transactional;

import com.caps.reservationapp.entity.ResOrder;
import com.caps.reservationapp.entity.Reservation;
// import com.caps.reservationapp.mapper.ReservationMapper;
import com.caps.reservationapp.mapper.ReservationMapperImpl;
import com.caps.reservationapp.response.ResOrderDto;
import com.caps.reservationapp.response.ReservationDto;
import com.caps.reservationapp.repository.ResOrderRepo;
import com.caps.reservationapp.repository.ReservationRepo;

@Transactional
public class ReservationService {

  @Autowired
  private ReservationRepo reservationRepo;

  @Autowired
  private ResOrderRepo resOrderRepo;

  @Autowired
  private ReservationMapperImpl mapper;

  public Optional<ReservationDto> getReservationById(UUID id) {
    Optional<Reservation> reservation = reservationRepo.findById(id);
    if (reservation.isEmpty()) {
      return Optional.empty();
    }
    ReservationDto reservationDto = mapper.toReservationDto(reservation.get());
    return Optional.of(reservationDto);
  }

  public List<ReservationDto> getAllReservations() {
    List<ReservationDto> reservationsDto = new ArrayList<ReservationDto>();
    List<Reservation> reservations = reservationRepo.findAll();
    if (reservations.isEmpty()) {
      return reservationsDto;
    }
    reservationsDto.addAll(mapper.toReservationDtoList(reservations));
    return reservationsDto;
  }

  public List<ReservationDto> getReservationsByUserId(UUID userId) {
    List<ReservationDto> reservationsDto = new ArrayList<ReservationDto>();
    List<Reservation> reservations = reservationRepo.findByUserId(userId);
    if (reservations.isEmpty()) {
      return reservationsDto;
    }
    reservationsDto.addAll(mapper.toReservationDtoList(reservations));
    return reservationsDto;
  }

  public ReservationDto createReservation(ReservationDto reservationDto) {
    List<ResOrderDto> orders = reservationDto.getOrders();
    
    reservationDto.setStatus("active");
    reservationDto.setCreatedAt(LocalDateTime.now().toString());
    reservationDto.setUpdatedAt(LocalDateTime.now().toString());
    Reservation reservation = mapper.toReservationEntity(reservationDto);
    reservation = reservationRepo.saveAndFlush(reservation);
    reservation = reservationRepo.findById(reservation.getId()).get();

    for (ResOrderDto order : orders) {
      ResOrder resOrder = mapper.toResOrderEntity(order, reservation);
      resOrder = resOrderRepo.saveAndFlush(resOrder);
    }

    resOrderRepo.flush();
    reservationRepo.flush();
    Reservation savedReservation = reservationRepo.findById(reservation.getId()).get();
    return mapper.toReservationDto(savedReservation);
  }

  public Optional<ReservationDto> updateReservation(UUID id, ReservationDto reservationDto) {
    Optional<Reservation> originalReservation = reservationRepo.findById(id);
    if (originalReservation.isEmpty()) {
      return Optional.empty();
    }

    List<ResOrder> originalOrders = originalReservation.get().getOrders();
    if (!originalOrders.isEmpty()) {
      for (ResOrder originalOrder : originalOrders) {
        resOrderRepo.deleteById(originalOrder.getId());
      }
    }
    resOrderRepo.flush();

    List<ResOrderDto> newOrders = reservationDto.getOrders();
    if (reservationDto.getStatus() == null || reservationDto.getStatus() == "") {
      reservationDto.setStatus("active");
    }
    reservationDto.setCreatedAt(originalReservation.get().getCreatedAt());
    reservationDto.setUpdatedAt(LocalDateTime.now().toString());

    Reservation reservation = mapper.toReservationEntity(reservationDto);
    reservation = reservationRepo.saveAndFlush(reservation);
    reservation = reservationRepo.findById(reservation.getId()).get();

    for (ResOrderDto newOrder : newOrders) {
      ResOrder resOrder = mapper.toResOrderEntity(newOrder, reservation);
      resOrder.setId(null);
      resOrder = resOrderRepo.saveAndFlush(resOrder);
    }

    resOrderRepo.flush();
    reservationRepo.flush();
    Reservation savedReservation = reservationRepo.findById(reservation.getId()).get();
    return Optional.of(mapper.toReservationDto(savedReservation));
  }

  public boolean deleteReservation(UUID id) {
    Optional<Reservation> reservation = reservationRepo.findById(id);
    if (reservation.isEmpty()) {
      return false;
    }
    List<ResOrder> orders = reservation.get().getOrders();
    if (!orders.isEmpty()) {
      for (ResOrder order: orders) {
        resOrderRepo.deleteById(order.getId());
      }
    }
    reservationRepo.deleteById(id);
    return true;
  }

}
