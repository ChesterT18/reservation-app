package com.caps.reservationapp.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.caps.reservationapp.mapper.ReservationMapperImpl;

@Configuration
public class MapperConfig {
  
  @Bean
  public ModelMapper modelMapperBean() {
    return new ModelMapper();
  }

  @Bean
  public ReservationMapperImpl reservationMapperBean() {
    return new ReservationMapperImpl();
  }

}
