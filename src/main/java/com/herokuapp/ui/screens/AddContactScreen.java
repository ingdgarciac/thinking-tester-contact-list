package com.herokuapp.ui.screens;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/** Class to model the base screen. */
@Getter
public class AddContactScreen extends BaseScreen {

  @FindBy(id = "logout")
  private WebElement logoutButton;

  @FindBy(id = "firstName")
  private WebElement inputFirstName;

  @FindBy(id = "lastName")
  private WebElement inputLastName;

  @FindBy(id = "birthdate")
  private WebElement inputBirthDate;

  @FindBy(id = "email")
  private WebElement inputEmail;

  @FindBy(id = "phone")
  private WebElement inputPhone;

  @FindBy(id = "street1")
  private WebElement inputStreet1;

  @FindBy(id = "street2")
  private WebElement inputStreet2;

  @FindBy(id = "city")
  private WebElement inputCity;

  @FindBy(id = "stateProvince")
  private WebElement inputState;

  @FindBy(id = "postalCode")
  private WebElement inputPostalCode;

  @FindBy(id = "country")
  private WebElement inputCountry;

  @FindBy(id = "submit")
  private WebElement submitButton;

  @FindBy(id = "cancel")
  private WebElement cancelButton;
}
