package com.caps.reservationapp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.caps.reservationapp.response.UserDto;
import com.caps.reservationapp.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{email}/{password}")
    private ResponseEntity<UserDto> getUser(@PathVariable String email, @PathVariable String password) {
        Optional<UserDto> user = userService.getUserByEmailAndPassword(email, password);
        if (user.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(user.get());
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

}
