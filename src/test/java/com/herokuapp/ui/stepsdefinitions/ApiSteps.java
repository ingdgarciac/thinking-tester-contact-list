package com.herokuapp.ui.stepsdefinitions;

import static com.herokuapp.api.tasks.UsersTasks.createNewUser;

import io.cucumber.java.en.Given;

public class ApiSteps {

  @Given("a new user of the contact list app")
  public void aNewUserOfTheContactListApp() {
    createNewUser();
  }
}
