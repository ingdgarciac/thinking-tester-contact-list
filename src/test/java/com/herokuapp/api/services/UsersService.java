package com.herokuapp.api.services;

import static com.herokuapp.Constants.PATH_LOGIN;
import static com.herokuapp.Constants.PATH_ME;
import static com.herokuapp.Constants.PATH_USERS;
import static com.herokuapp.Constants.PROJECT_URL;
import static io.restassured.http.ContentType.JSON;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;

import com.herokuapp.api.Reply;
import com.herokuapp.api.Request;
import com.herokuapp.api.dtos.LoginRequest;
import com.herokuapp.api.dtos.NewUserRequest;
import com.herokuapp.api.dtos.NewUserResponse;
import com.herokuapp.utils.Assertion;
import com.herokuapp.utils.DataContext;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UsersService {

  /**
   * Create a new user
   *
   * @param request new user request information
   */
  public static NewUserResponse AddUser(NewUserRequest request) {
    Reply reply =
        new Request()
            .baseUri(PROJECT_URL)
            .basePath(PATH_USERS)
            .contentType(JSON)
            .body(request)
            .post();

    Assertion.hardAssert("Status code", reply.getResponse().statusCode(), SC_CREATED);

    return reply.getResponse().body().as(NewUserResponse.class);
  }

  /** Delete user */
  public static void deleteUser() {
    Reply reply =
        new Request()
            .baseUri(PROJECT_URL)
            .basePath(PATH_USERS + PATH_ME)
            .bearerAuth(DataContext.getUser().getToken())
            .contentType(JSON)
            .delete();

    Assertion.hardAssert("Status code", reply.getResponse().statusCode(), SC_OK);
  }

  public static NewUserResponse loginUser(LoginRequest loginRequest) {
    Reply reply =
        new Request()
            .baseUri(PROJECT_URL)
            .basePath(PATH_USERS + PATH_LOGIN)
            .body(loginRequest)
            .contentType(JSON)
            .post();

    Assertion.hardAssert("Status code", reply.getResponse().statusCode(), SC_OK);

    return reply.getResponse().body().as(NewUserResponse.class);
  }
}
