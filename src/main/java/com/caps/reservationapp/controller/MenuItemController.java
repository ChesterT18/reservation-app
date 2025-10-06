package com.caps.reservationapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.caps.reservationapp.response.MenuItemResponse;
import com.caps.reservationapp.service.MenuItemService;

@RestController
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    @GetMapping("/menu/{id}")
    private ResponseEntity<MenuItemResponse> getMenuItem(@PathVariable("id") int id) {
        MenuItemResponse menuItem = menuItemService.getMenuItemById(id);
        return ResponseEntity.status(HttpStatus.OK).body(menuItem);
    }

    @GetMapping("/menu")
    private ResponseEntity<List<MenuItemResponse>> getAllMenuItems() {
        List<MenuItemResponse> menu = menuItemService.getAllMenuItems();
        return ResponseEntity.status(HttpStatus.OK).body(menu);
    }

}
