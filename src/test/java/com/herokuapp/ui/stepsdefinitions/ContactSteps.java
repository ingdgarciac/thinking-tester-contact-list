package com.herokuapp.ui.stepsdefinitions;

import com.herokuapp.ui.questions.AddContactQuestions;
import com.herokuapp.ui.questions.ContactListQuestions;
import com.herokuapp.ui.questions.LoginQuestions;
import com.herokuapp.ui.tasks.AddContactTasks;
import com.herokuapp.ui.tasks.ContactListTasks;
import com.herokuapp.ui.tasks.LoginTasks;
import com.herokuapp.utils.UserInfo;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactSteps {

  private final LoginTasks loginTasks = new LoginTasks();
  private final LoginQuestions loginQuestions = new LoginQuestions();
  private final ContactListTasks contactListTasks = new ContactListTasks();
  private final ContactListQuestions contactListQuestions = new ContactListQuestions();
  private final AddContactTasks addContactTasks = new AddContactTasks();
  private final AddContactQuestions addContactQuestions = new AddContactQuestions();

  @And("login process is completed successfully")
  public void loginProcessIsCompletedSuccessfully() {
    loginQuestions.validateScreen();
    loginTasks
        .setUserName(UserInfo.getUser().getUser().getEmail())
        .setPassword(UserInfo.getPassword())
        .clickOnSubmitButton();
    contactListQuestions.validateScreen();
  }

  @When("the user creates a new contact")
  public void theUserCreatesANewContact() {
    contactListTasks.clickOnAddNewContact();
    addContactQuestions.validateScreen();
    addContactTasks.setNewContactInfo().clickOnSubmit();
  }

  @Then("the created contact appears in the contact list screen")
  public void theCreatedContactAppearsInTheContactListScreen() {
    contactListQuestions.validateNewContact();
    contactListQuestions.validateContactInfo();
  }
}
