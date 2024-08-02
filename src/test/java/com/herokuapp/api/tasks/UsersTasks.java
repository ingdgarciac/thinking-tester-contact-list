package com.herokuapp.api.tasks;

import static com.herokuapp.Constants.EMAIL_DOMAIN;
import static com.herokuapp.Constants.UNDERSCORE;

import com.herokuapp.api.dtos.NewUserRequest;
import com.herokuapp.api.dtos.NewUserResponse;
import com.herokuapp.api.services.UsersService;
import com.herokuapp.utils.UserInfo;
import io.qameta.allure.Step;
import lombok.experimental.UtilityClass;
import net.datafaker.Faker;

@UtilityClass
public class UsersTasks {

  private final Faker faker = new Faker();

  @Step("Create login account to the application")
  public static void createNewUser() {
    NewUserRequest userRequest = getNewUserRequest();
    NewUserResponse user = UsersService.AddUser(userRequest);
    UserInfo.setUser(user);
    UserInfo.setPassword(userRequest.getPassword());
  }

  private NewUserRequest getNewUserRequest() {
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = firstName.concat(UNDERSCORE).concat(lastName).concat(EMAIL_DOMAIN);
    String password = faker.internet().password();
    return NewUserRequest.builder()
        .firstName(firstName)
        .lastName(lastName)
        .email(email)
        .password(password)
        .build();
  }
}
