package com.caps.reservationapp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.caps.reservationapp.service.UserService;

@Configuration
public class UserConfig {
  
  @Bean
  public UserService userServiceBean() {
    return new UserService();
  }

}
