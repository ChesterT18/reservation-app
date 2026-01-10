package com.caps.reservationapp.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
import java.util.UUID;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import jakarta.transaction.Transactional;

import com.caps.reservationapp.entity.Feedback;
import com.caps.reservationapp.response.FeedbackDto;
import com.caps.reservationapp.repository.FeedbackRepo;

@Transactional
public class FeedbackService {

  @Autowired
  private FeedbackRepo feedbackRepo;

  @Autowired
  private ModelMapper mapper;

  public Optional<FeedbackDto> getFeedbackById(UUID id) {
    Optional<Feedback> feedback = feedbackRepo.findById(id);
    if (feedback.isEmpty()) {
      return Optional.empty();
    }
    FeedbackDto feedbackDto = mapper.map(feedback, FeedbackDto.class);
    return Optional.of(feedbackDto);
  }

  public List<FeedbackDto> getAllFeedbacks() {
    List<FeedbackDto> feedbacksDto = new ArrayList<FeedbackDto>();
    List<Feedback> feedbacks = feedbackRepo.findAll();
    if (feedbacks.isEmpty()) {
      return feedbacksDto;
    }
    feedbacks.forEach(m -> feedbacksDto.add(mapper.map(m, FeedbackDto.class)));
    return feedbacksDto;
  }

  public FeedbackDto createFeedback(FeedbackDto feedbackDto) {
    feedbackDto.setCreatedAt(LocalDateTime.now().toString());
    Feedback feedback = mapper.map(feedbackDto, Feedback.class);
    feedback = feedbackRepo.saveAndFlush(feedback);
    return mapper.map(feedback, FeedbackDto.class);
  }

}
