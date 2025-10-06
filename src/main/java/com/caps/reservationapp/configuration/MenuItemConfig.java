package com.caps.reservationapp.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.caps.reservationapp.service.MenuItemService;

@Configuration
public class MenuItemConfig {

  @Bean
  public MenuItemService menuItemServiceBean() {
    return new MenuItemService();
  }

  @Bean
  public ModelMapper modelMapperBean() {
    return new ModelMapper();
  }

}
