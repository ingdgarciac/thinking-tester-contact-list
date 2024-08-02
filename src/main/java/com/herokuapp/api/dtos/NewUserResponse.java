package com.herokuapp.api.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** Class to model the DTO in the response of a new user. */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewUserResponse {

  private UserDto user;
  private String token;
}
