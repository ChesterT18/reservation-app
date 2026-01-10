package com.caps.reservationapp.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.caps.reservationapp.response.MenuItemDto;
import com.caps.reservationapp.service.MenuItemService;

@RestController
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    @GetMapping("/menu/{id}")
    private ResponseEntity<MenuItemDto> getMenuItem(@PathVariable UUID id) {
        Optional<MenuItemDto> menuItem = menuItemService.getMenuItemById(id);
        if (menuItem.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(menuItem.get());
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

    @GetMapping("/menu")
    private ResponseEntity<List<MenuItemDto>> getAllMenuItems() {
        List<MenuItemDto> menu = menuItemService.getAllMenuItems();
        return ResponseEntity.status(HttpStatus.OK).body(menu);
    }

}
