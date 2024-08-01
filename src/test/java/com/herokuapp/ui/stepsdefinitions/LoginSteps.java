package com.herokuapp.ui.stepsdefinitions;

import com.herokuapp.ui.questions.LoginQuestions;
import com.herokuapp.ui.tasks.LoginTasks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

  private final LoginTasks loginTasks = new LoginTasks();
  private final LoginQuestions loginQuestions = new LoginQuestions();

  @And("login process is completed successfully")
  public void loginProcessIsCompletedSuccessfully() {}

  @When("the user creates a new contact")
  public void theUserCreatesANewContact() {}

  @Then("the created contact appears in the contact list screen")
  public void theCreatedContactAppearsInTheContactListScreen() {}
}
