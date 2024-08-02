package com.herokuapp.api.dtos;

import lombok.Builder;
import lombok.Data;

/** Class to model the DTO to request a new contact. */
@Data
@Builder
public class ContactDto {

  private String firstName;
  private String lastName;
  private String dateOfBirth;
  private String email;
  private String phone;
  private String address1;
  private String address2;
  private String city;
  private String province;
  private String postalCode;
  private String country;
}
