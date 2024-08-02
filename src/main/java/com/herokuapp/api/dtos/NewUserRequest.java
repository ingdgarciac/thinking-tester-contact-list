package com.herokuapp.api.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** Class to model the DTO to request a new user. */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewUserRequest {

  private String firstName;
  private String lastName;
  private String email;
  private String password;
}
