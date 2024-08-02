package com.herokuapp.api;

import static io.restassured.http.Method.DELETE;
import static io.restassured.http.Method.GET;
import static io.restassured.http.Method.POST;
import static io.restassured.http.Method.PUT;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import java.util.Objects;

/** Class to model RestAssured request. */
public class Request {

  private final RequestSpecification requestSpecification;

  /** Constructor of the class. */
  public Request() {
    requestSpecification =
        RestAssured.given()
            .filter(new AllureRestAssured())
            .filter(new RequestLoggingFilter(LogDetail.ALL, false, System.out))
            .filter(new ResponseLoggingFilter(LogDetail.ALL, false, System.out))
            .relaxedHTTPSValidation()
            .redirects()
            .follow(false);
  }

  public Request baseUri(String baseUri) {
    requestSpecification.baseUri(baseUri);
    return this;
  }

  public Request basePath(String basePath) {
    requestSpecification.basePath(basePath);
    return this;
  }

  public Request contentType(ContentType contentType) {
    requestSpecification.contentType(contentType);
    return this;
  }

  public Request bearerAuth(String token) {
    requestSpecification.header("Authorization", "Bearer " + token);
    return this;
  }

  public Request body(Object obj) {
    requestSpecification.body(obj);
    return this;
  }

  private Reply sendRequest(Method method) {
    ValidatableResponse response = this.requestSpecification.request(method).then();

    if (!Objects.isNull(response) && !Objects.isNull(response.extract())) {
      return new Reply(response.extract().response());
    }
    return null;
  }

  public Reply get() {
    return sendRequest(GET);
  }

  public Reply post() {
    return sendRequest(POST);
  }

  public Reply put() {
    return sendRequest(PUT);
  }

  public Reply delete() {
    return sendRequest(DELETE);
  }
}
