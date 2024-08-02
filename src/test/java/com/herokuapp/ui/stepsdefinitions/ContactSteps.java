package com.herokuapp.ui.stepsdefinitions;

import com.herokuapp.ui.questions.AddOrEditContactQuestions;
import com.herokuapp.ui.questions.ContactDetailsQuestions;
import com.herokuapp.ui.questions.ContactListQuestions;
import com.herokuapp.ui.questions.LoginQuestions;
import com.herokuapp.ui.tasks.AddOrEditContactTasks;
import com.herokuapp.ui.tasks.ContactDetailsTasks;
import com.herokuapp.ui.tasks.ContactListTasks;
import com.herokuapp.ui.tasks.LoginTasks;
import com.herokuapp.utils.DataContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactSteps {

  private final LoginTasks loginTasks = new LoginTasks();
  private final LoginQuestions loginQuestions = new LoginQuestions();
  private final ContactListTasks contactListTasks = new ContactListTasks();
  private final ContactListQuestions contactListQuestions = new ContactListQuestions();
  private final AddOrEditContactTasks addOrEditContactTasks = new AddOrEditContactTasks();
  private final AddOrEditContactQuestions addOrEditContactQuestions =
      new AddOrEditContactQuestions();
  private final ContactDetailsTasks contactDetailsTasks = new ContactDetailsTasks();
  private final ContactDetailsQuestions contactDetailsQuestions = new ContactDetailsQuestions();

  @And("login process is completed successfully")
  public void loginProcessIsCompletedSuccessfully() {
    loginQuestions.validateScreen();
    loginTasks
        .setUserName(DataContext.getUser().getUser().getEmail())
        .setPassword(DataContext.getPassword())
        .clickOnSubmitButton();
    contactListQuestions.validateScreen();
  }

  @When("the user creates a new contact")
  public void theUserCreatesANewContact() {
    contactListTasks.clickOnAddNewContact();
    addOrEditContactQuestions.validateScreen();
    addOrEditContactTasks.setNewContactInfo().clickOnSubmit();
  }

  @Then("the created contact appears")
  public void theCreatedContactAppears() {
    contactListQuestions.validateNewContact();
    contactListQuestions.validateContactInfo();
  }

  @When("the user taps on created contact")
  public void theUserTapsOnCreatedContact() {
    contactListTasks.clickOnAvailableContact();
  }

  @Then("the contact details appears")
  public void theContactDetailsAppears() {
    contactDetailsQuestions.validateScreen();
  }

  @When("the user initiates the edition process")
  public void theUserInitiatesTheEditionProcess() {
    contactDetailsTasks.clickOnEditButton();
    addOrEditContactQuestions.validateScreen();
    addOrEditContactTasks.updateContactData();
    addOrEditContactTasks.clickOnSubmit();
    contactDetailsTasks.clickOnReturnToContactList();
  }

  @Then("the contact is update it")
  public void theContactIsUpdateIt() {
    contactListQuestions.validateNewContact();
    contactListQuestions.validateContactInfo();
  }

  @When("the user initiates the deletion process")
  public void theUserInitiatesTheDeletionProcess() {
    contactDetailsTasks.clickOnDeleteButton();
    contactDetailsTasks.confirmDelete();
  }

  @Then("the contact list is empty")
  public void theContactListIsEmpty() {
    contactListQuestions.validateScreen();
  }

  @When("the user taps on logout")
  public void theUserTapsOnLogout() {
    contactListTasks.clickOnLogout();
  }

  @Then("login screen is shown")
  public void loginScreenIsShown() {
    loginQuestions.validateScreen();
  }
}
