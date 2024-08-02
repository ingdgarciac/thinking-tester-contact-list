package com.herokuapp.ui.screens;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/** Abstract class to model the contact screen. */
@Getter
public abstract class BaseContactScreen extends BaseScreen {

  @FindBy(id = "logout")
  private WebElement logoutButton;

  @FindBy(id = "firstName")
  private WebElement firstName;

  @FindBy(id = "lastName")
  private WebElement lastName;

  @FindBy(id = "birthdate")
  private WebElement birthDate;

  @FindBy(id = "email")
  private WebElement email;

  @FindBy(id = "phone")
  private WebElement phone;

  @FindBy(id = "street1")
  private WebElement street1;

  @FindBy(id = "street2")
  private WebElement street2;

  @FindBy(id = "city")
  private WebElement city;

  @FindBy(id = "stateProvince")
  private WebElement state;

  @FindBy(id = "postalCode")
  private WebElement postalCode;

  @FindBy(id = "country")
  private WebElement country;
}
