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

import com.caps.reservationapp.response.FeedbackDto;
import com.caps.reservationapp.service.FeedbackService;

@RestController
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping("/feedbacks/{id}")
    private ResponseEntity<FeedbackDto> getFeedback(@PathVariable UUID id) {
        Optional<FeedbackDto> feedback = feedbackService.getFeedbackById(id);
        if (feedback.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(feedback.get());
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

    @GetMapping("/feedbacks")
    private ResponseEntity<List<FeedbackDto>> getAllFeedbacks() {
        List<FeedbackDto> feedbacks = feedbackService.getAllFeedbacks();
        return ResponseEntity.status(HttpStatus.OK).body(feedbacks);
    }

    @PostMapping("/feedbacks")
    public ResponseEntity<FeedbackDto> createFeedback(@RequestBody FeedbackDto feedbackDto) {
        FeedbackDto createdFeedbackDto = feedbackService.createFeedback(feedbackDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFeedbackDto);
    }

}
