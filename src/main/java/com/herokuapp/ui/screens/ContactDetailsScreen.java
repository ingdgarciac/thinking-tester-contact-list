package com.herokuapp.ui.screens;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/** Class to model the Contact details screen. */
@Getter
public class ContactDetailsScreen extends BaseContactScreen {

  @FindBy(id = "edit-contact")
  private WebElement editContactButton;

  @FindBy(id = "delete")
  private WebElement deleteButton;

  @FindBy(id = "return")
  private WebElement returnButton;
}
