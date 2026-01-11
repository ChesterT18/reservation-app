package com.caps.reservationapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.Optional;
import jakarta.transaction.Transactional;

import com.caps.reservationapp.entity.User;
import com.caps.reservationapp.response.UserDto;
import com.caps.reservationapp.repository.UserRepo;

@Transactional
public class UserService {

  @Autowired
  private UserRepo userRepo;

  @Autowired
  private ModelMapper mapper;

  public Optional<UserDto> getUserByEmailAndPassword(String email, String password) {
    Optional<User> user = userRepo.findByEmailAndPassword(email, password);
    if (user.isEmpty()) {
      return Optional.empty();
    }
    UserDto userDto = mapper.map(user, UserDto.class);
    return Optional.of(userDto);
  }

  public UserDto createUser(UserDto userDto) {
    userDto.setCreatedAt(LocalDateTime.now());
    User user = mapper.map(userDto, User.class);
    user = userRepo.saveAndFlush(user);
    return mapper.map(user, UserDto.class);
  }

}
