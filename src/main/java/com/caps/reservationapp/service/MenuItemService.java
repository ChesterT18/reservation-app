package com.caps.reservationapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;
import java.util.Optional;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;
import jakarta.transaction.Transactional;

import com.caps.reservationapp.entity.MenuItem;
import com.caps.reservationapp.response.MenuItemDto;
import com.caps.reservationapp.repository.MenuItemRepo;

@Transactional
public class MenuItemService {

  @Autowired
  private MenuItemRepo menuItemRepo;

  @Autowired
  private ModelMapper mapper;

  public Optional<MenuItemDto> getMenuItemById(UUID id) {
    Optional<MenuItem> menuItem = menuItemRepo.findById(id);
    if (menuItem.isEmpty()) {
      return Optional.empty();
    }
    MenuItemDto menuItemDto = mapper.map(menuItem, MenuItemDto.class);
    return Optional.of(menuItemDto);
  }

  public List<MenuItemDto> getAllMenuItems() {
    List<MenuItemDto> menuItemsDto = new ArrayList<MenuItemDto>();
    List<MenuItem> menuItems = menuItemRepo.findAll();
    if (menuItems.isEmpty()) {
      return menuItemsDto;
    }
    menuItems.forEach(m -> menuItemsDto.add(mapper.map(m, MenuItemDto.class)));
    return menuItemsDto;
  }

}
