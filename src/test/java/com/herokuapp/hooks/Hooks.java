package com.herokuapp.hooks;

import static com.herokuapp.api.services.UsersService.deleteUser;
import static org.testng.Assert.assertTrue;

import com.herokuapp.ui.driver.Device;
import com.herokuapp.ui.screens.LoginScreen;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public class Hooks {

  @Before
  public void startTest(Scenario scenario) {
    log.info("Starting scenario: {}", scenario.getName());
    LoginScreen loginScreen = new LoginScreen();
    assertTrue(loginScreen.getInputEmail().isDisplayed(), "Login screen is visible");
  }

  @After
  public void finishTest(Scenario scenario) {
    log.info("Ending scenario: {}", scenario.getName());
    log.info("Disposing data");
    deleteUser();
    Device.getDriver().close();
  }
}
