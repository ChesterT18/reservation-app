package com.caps.reservationapp.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.caps.reservationapp.response.UserRatingDto;
import com.caps.reservationapp.service.UserRatingService;

@RestController
public class UserRatingController {

    @Autowired
    private UserRatingService userRatingService;

    @GetMapping("/userRatings/{id}")
    private ResponseEntity<UserRatingDto> getUserRating(@PathVariable UUID id) {
        Optional<UserRatingDto> userRating = userRatingService.getUserRatingById(id);
        if (userRating.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(userRating.get());
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

    @GetMapping("/userRatings")
    private ResponseEntity<List<UserRatingDto>> getAllUserRatings() {
        List<UserRatingDto> userRatings = userRatingService.getAllUserRatings();
        return ResponseEntity.status(HttpStatus.OK).body(userRatings);
    }

    @PostMapping("/userRatings")
    public ResponseEntity<UserRatingDto> createUserRating(@RequestBody UserRatingDto userRatingDto) {
        UserRatingDto createdUserRatingDto = userRatingService.createUserRating(userRatingDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUserRatingDto);
    }

}
