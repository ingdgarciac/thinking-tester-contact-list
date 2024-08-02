package com.herokuapp.ui.questions;

import static com.herokuapp.enums.Timeout.MEDIUM_TIME;
import static com.herokuapp.utils.WaitActions.waitUntilElementIsVisible;

import com.herokuapp.ui.screens.AddContactScreen;
import com.herokuapp.utils.Assertion;
import io.qameta.allure.Step;

public class AddContactQuestions extends AddContactScreen {

  @Step("Validate add contact screen visibility")
  public void validateScreen() {
    waitUntilElementIsVisible(getInputFirstName(), MEDIUM_TIME);
    Assertion.softAssert("First name input is visible", getInputFirstName().isDisplayed(), true);
    Assertion.softAssert("Last name input is visible", getInputFirstName().isDisplayed(), true);
    Assertion.softAssert("Date of birth input is visible", getInputFirstName().isDisplayed(), true);
    Assertion.softAssert("Email input is visible", getInputFirstName().isDisplayed(), true);
    Assertion.softAssert("Phone input is visible", getInputFirstName().isDisplayed(), true);
    Assertion.softAssert("Street 1 input is visible", getInputFirstName().isDisplayed(), true);
    Assertion.softAssert("Street 2 input is visible", getInputFirstName().isDisplayed(), true);
    Assertion.softAssert("City input is visible", getInputFirstName().isDisplayed(), true);
    Assertion.softAssert("State input is visible", getInputFirstName().isDisplayed(), true);
    Assertion.softAssert("Postal code input is visible", getInputFirstName().isDisplayed(), true);
    Assertion.softAssert("Country input is visible", getInputFirstName().isDisplayed(), true);
    Assertion.softAssert("Submit button is visible", getSubmitButton().isDisplayed(), true);
    Assertion.softAssert("Cancel button is visible", getCancelButton().isDisplayed(), true);
    Assertion.softAssert("Logout button is visible", getLogoutButton().isDisplayed(), true);
  }
}
