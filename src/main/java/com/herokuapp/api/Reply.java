package com.herokuapp.api;

import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import lombok.Data;

/** Class to model RestAssured response. */
@Data
@AllArgsConstructor
public class Reply {

  private final Response response;
}
