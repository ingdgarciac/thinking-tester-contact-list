package com.herokuapp.ui.screens;

import com.herokuapp.ui.driver.Device;
import org.openqa.selenium.support.PageFactory;

/** Class to model the base screen. */
public abstract class BaseScreen {

  public BaseScreen() {
    PageFactory.initElements(Device.getDriver(), this);
    Device.getDriver().manage().window().maximize();
  }
}
