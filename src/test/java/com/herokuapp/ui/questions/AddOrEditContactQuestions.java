package com.herokuapp.ui.questions;

import static com.herokuapp.enums.Timeout.MEDIUM_TIME;
import static com.herokuapp.utils.WaitActions.waitUntilElementIsVisible;

import com.herokuapp.ui.screens.AddOrEditContactScreen;
import com.herokuapp.utils.Assertion;
import io.qameta.allure.Step;

public class AddOrEditContactQuestions extends AddOrEditContactScreen {

  @Step("Validate add contact screen visibility")
  public void validateScreen() {
    waitUntilElementIsVisible(getFirstName(), MEDIUM_TIME);
    Assertion.softAssert("First name input is visible", getFirstName().isDisplayed(), true);
    Assertion.softAssert("Last name input is visible", getLastName().isDisplayed(), true);
    Assertion.softAssert("Date of birth input is visible", getBirthDate().isDisplayed(), true);
    Assertion.softAssert("Email input is visible", getEmail().isDisplayed(), true);
    Assertion.softAssert("Phone input is visible", getPhone().isDisplayed(), true);
    Assertion.softAssert("Street 1 input is visible", getStreet1().isDisplayed(), true);
    Assertion.softAssert("Street 2 input is visible", getStreet2().isDisplayed(), true);
    Assertion.softAssert("City input is visible", getCity().isDisplayed(), true);
    Assertion.softAssert("State input is visible", getState().isDisplayed(), true);
    Assertion.softAssert("Postal code input is visible", getPostalCode().isDisplayed(), true);
    Assertion.softAssert("Country input is visible", getCountry().isDisplayed(), true);
    Assertion.softAssert("Logout button is visible", getLogoutButton().isDisplayed(), true);
  }
}
