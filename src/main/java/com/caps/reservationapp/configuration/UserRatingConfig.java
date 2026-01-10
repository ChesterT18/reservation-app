package com.caps.reservationapp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.caps.reservationapp.service.UserRatingService;

@Configuration
public class UserRatingConfig {
  
  @Bean
  public UserRatingService UserRatingServiceBean() {
    return new UserRatingService();
  }

}
