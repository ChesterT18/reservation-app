package com.caps.reservationapp.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.caps.reservationapp.response.ReservationDto;
import com.caps.reservationapp.service.ReservationService;

@RestController
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/reservations/{id}")
    private ResponseEntity<ReservationDto> getReservation(@PathVariable UUID id) {
        Optional<ReservationDto> reservation = reservationService.getReservationById(id);
        if (reservation.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(reservation.get());
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

    @GetMapping("/reservations/user/{userId}")
    private ResponseEntity<List<ReservationDto>> getReservationsByUserId(@PathVariable UUID userId) {
        List<ReservationDto> reservations = reservationService.getReservationsByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(reservations);
    }

    @GetMapping("/reservations")
    private ResponseEntity<List<ReservationDto>> getAllReservations() {
        List<ReservationDto> reservations = reservationService.getAllReservations();
        return ResponseEntity.status(HttpStatus.OK).body(reservations);
    }

    @PostMapping("/reservations")
    public ResponseEntity<ReservationDto> createReservation(@RequestBody ReservationDto reservationDto) {
        ReservationDto createdReservationDto = reservationService.createReservation(reservationDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdReservationDto);
    }

    @PutMapping("/reservations/{id}")
    public ResponseEntity<ReservationDto> updateReservation(
        @PathVariable UUID id,
        @RequestBody ReservationDto reservationDto
    ) {
        Optional<ReservationDto> updatedReservationDto = reservationService.updateReservation(id, reservationDto);
        if (updatedReservationDto.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        } else {
           return ResponseEntity.status(HttpStatus.OK).body(updatedReservationDto.get());
        }
    }

    @DeleteMapping("reservations/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable UUID id) {
        boolean deleted = reservationService.deleteReservation(id);
        if (deleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
