package com.herokuapp.ui.questions;

import static com.herokuapp.enums.Timeout.MEDIUM_TIME;
import static com.herokuapp.utils.WaitActions.waitUntilElementIsVisible;

import com.herokuapp.ui.screens.LoginScreen;
import com.herokuapp.utils.Assertion;
import io.qameta.allure.Step;

public class LoginQuestions extends LoginScreen {

  @Step("Validate login screen elements")
  public void validateScreen() {
    waitUntilElementIsVisible(getInputEmail(), MEDIUM_TIME);
    Assertion.softAssert("Email input is visible", getInputEmail().isDisplayed(), true);
    Assertion.softAssert("Password input is visible", getInputPassword().isDisplayed(), true);
    Assertion.softAssert("Submit button is visible", getSubmitButton().isDisplayed(), true);
  }
}
