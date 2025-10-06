package com.caps.reservationapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.caps.reservationapp.entity.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import com.caps.reservationapp.repository.MenuItemRepo;
import com.caps.reservationapp.response.MenuItemResponse;

import jakarta.transaction.Transactional;

@Transactional
public class MenuItemService {

  @Autowired
  private MenuItemRepo menuItemRepo;

  @Autowired
  private ModelMapper mapper;

  public MenuItemResponse getMenuItemById(int id) {
    Optional<MenuItem> menuItem = menuItemRepo.findById(id);
    MenuItemResponse menuItemResponse = mapper.map(menuItem, MenuItemResponse.class);
    return menuItemResponse;
  }

  public List<MenuItemResponse> getAllMenuItems() {
    List<MenuItem> menu = menuItemRepo.findAll();
    List<MenuItemResponse> menuResponse = new ArrayList<MenuItemResponse>();
    menu.forEach(m -> menuResponse.add(mapper.map(m, MenuItemResponse.class)));
    return menuResponse;
  }

}
