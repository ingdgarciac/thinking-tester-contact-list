package com.herokuapp.api.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** Class to model the DTO in the response of a new user. */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

  @JsonProperty("_id")
  private String id;

  private String firstName;
  private String lastName;
  private String email;

  @JsonProperty("__v")
  private String version;
}
