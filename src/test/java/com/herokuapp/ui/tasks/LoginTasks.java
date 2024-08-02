package com.herokuapp.ui.tasks;

import static com.herokuapp.utils.DeviceActions.click;
import static com.herokuapp.utils.DeviceActions.sendKeys;

import com.herokuapp.ui.screens.LoginScreen;
import io.qameta.allure.Step;

public class LoginTasks extends LoginScreen {

  @Step("Set user name in the login screen")
  public LoginTasks setUserName(String userName) {
    sendKeys(getInputEmail(), userName);
    return this;
  }

  @Step("Set password in the login screen")
  public LoginTasks setPassword(String password) {
    sendKeys(getInputPassword(), password);
    return this;
  }

  @Step("Click on submit button")
  public void clickOnSubmitButton() {
    click(getSubmitButton(), "Submit button");
  }
}
