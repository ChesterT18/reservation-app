package com.caps.reservationapp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.caps.reservationapp.service.ReservationService;

@Configuration
public class ReservationConfig {
  
  @Bean
  public ReservationService reservationServiceBean() {
    return new ReservationService();
  }

}
