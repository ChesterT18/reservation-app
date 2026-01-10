package com.caps.reservationapp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.caps.reservationapp.service.FeedbackService;

@Configuration
public class FeedbackConfig {
  
  @Bean
  public FeedbackService feedbackServiceBean() {
    return new FeedbackService();
  }

}
