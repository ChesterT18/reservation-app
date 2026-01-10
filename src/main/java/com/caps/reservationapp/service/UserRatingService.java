package com.caps.reservationapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;
import java.util.Optional;
import java.util.UUID;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import jakarta.transaction.Transactional;

import com.caps.reservationapp.entity.MenuItem;
import com.caps.reservationapp.entity.UserRating;
import com.caps.reservationapp.response.UserRatingDto;
import com.caps.reservationapp.repository.MenuItemRepo;
import com.caps.reservationapp.repository.UserRatingRepo;

@Transactional
public class UserRatingService {

  @Autowired
  private UserRatingRepo userRatingRepo;

  @Autowired
  private MenuItemRepo menuItemRepo;

  @Autowired
  private ModelMapper mapper;

  public Optional<UserRatingDto> getUserRatingById(UUID id) {
    Optional<UserRating> userRating = userRatingRepo.findById(id);
    if (userRating.isEmpty()) {
      return Optional.empty();
    }
    UserRatingDto userRatingDto = mapper.map(userRating, UserRatingDto.class);
    return Optional.of(userRatingDto);
  }

  public List<UserRatingDto> getAllUserRatings() {
    List<UserRatingDto> userRatingsDto = new ArrayList<UserRatingDto>();
    List<UserRating> userRatings = userRatingRepo.findAll();
    if (userRatings.isEmpty()) {
      return userRatingsDto;
    }
    userRatings.forEach(m -> userRatingsDto.add(mapper.map(m, UserRatingDto.class)));
    return userRatingsDto;
  }

  public UserRatingDto createUserRating(UserRatingDto userRatingDto) {
    userRatingDto.setCreatedAt(LocalDateTime.now().toString());
    UserRating userRating = mapper.map(userRatingDto, UserRating.class);
    userRating = userRatingRepo.saveAndFlush(userRating);

    if (userRating != null) {
      // update menu item rating
      Optional<MenuItem> menuItem = menuItemRepo.findById(userRating.getFoodId());
      if (!menuItem.isEmpty()) {
        double newTotal = menuItem.get().getAverageRating() * menuItem.get().getNoOfReviews() + userRating.getScore();
        menuItem.get().setNoOfReviews(menuItem.get().getNoOfReviews() + 1);
        menuItem.get().setAverageRating(newTotal / menuItem.get().getNoOfReviews());
        menuItemRepo.saveAndFlush(menuItem.get());
      }
    }

    return mapper.map(userRating, UserRatingDto.class);
  }

}
