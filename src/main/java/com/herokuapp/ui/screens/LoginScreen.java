package com.herokuapp.ui.screens;

import static com.herokuapp.Constants.PROJECT_URL;

import com.herokuapp.ui.driver.Device;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/** Class to model the login page. */
@Getter
public class LoginScreen extends BaseScreen {

  @FindBy(id = "email")
  private WebElement inputEmail;

  @FindBy(id = "password")
  private WebElement inputPassword;

  @FindBy(id = "submit")
  private WebElement submitButton;

  public LoginScreen() {
    super();
    Device.getDriver().get(PROJECT_URL);
  }
}
