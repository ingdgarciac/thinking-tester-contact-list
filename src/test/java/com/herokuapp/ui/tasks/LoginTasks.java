package com.herokuapp.ui.tasks;

import com.herokuapp.ui.screens.LoginScreen;
import io.qameta.allure.Step;

public class LoginTasks extends LoginScreen {

  @Step("Set user name in the login screen")
  public LoginTasks setUserName(String userName) {
    getInputEmail().sendKeys(userName);
    return this;
  }

  @Step("Set password in the login screen")
  public LoginTasks setPassword(String password) {
    getInputPassword().sendKeys(password);
    return this;
  }

  @Step("Click on submit button")
  public void clickOnSubmitButton() {
    getSubmitButton().click();
  }
}
