package com.caps.reservationapp.response;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Data;

@Data
public class UserDto implements Serializable {

  private UUID id;
  private String email;
  private String password;
  private String firstName;
  private String lastName;
  private String phoneNumber;
  private String role;
  private LocalDateTime createdAt;

}
