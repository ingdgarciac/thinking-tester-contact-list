package com.herokuapp.api.services;

import static com.herokuapp.Constants.PATH_ME;
import static com.herokuapp.Constants.PATH_USERS;
import static com.herokuapp.Constants.PROJECT_URL;
import static io.restassured.http.ContentType.JSON;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;
import static org.testng.Assert.assertEquals;

import com.herokuapp.api.Reply;
import com.herokuapp.api.Request;
import com.herokuapp.api.dtos.NewUserRequest;
import com.herokuapp.api.dtos.NewUserResponse;
import com.herokuapp.utils.UserInfo;
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

    assertEquals(reply.getResponse().statusCode(), SC_CREATED);

    return reply.getResponse().body().as(NewUserResponse.class);
  }

  /** Delete user */
  public static void deleteUser() {
    Reply reply =
        new Request()
            .baseUri(PROJECT_URL)
            .basePath(PATH_USERS + PATH_ME)
            .bearerAuth(UserInfo.getUser().getToken())
            .contentType(JSON)
            .delete();

    assertEquals(reply.getResponse().statusCode(), SC_OK);
  }
}
