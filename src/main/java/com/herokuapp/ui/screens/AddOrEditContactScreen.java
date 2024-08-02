package com.herokuapp.ui.screens;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/** Class to model the base screen. */
@Getter
public class AddOrEditContactScreen extends BaseContactScreen {

  @FindBy(id = "submit")
  private WebElement submitButton;

  @FindBy(id = "cancel")
  private WebElement cancelButton;
}
