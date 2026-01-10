package com.caps.reservationapp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.caps.reservationapp.service.DineTableService;

@Configuration
public class DineTableConfig {
  
  @Bean
  public DineTableService dineTableServiceBean() {
    return new DineTableService();
  }

}
