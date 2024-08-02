package com.herokuapp.ui.screens;

import java.util.List;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/** Class to model the contact list screen. */
@Getter
public class ContactListScreen extends BaseScreen {

  @FindBy(css = "header > h1")
  private WebElement headerTitle;

  @FindBy(css = "div.main-content > p:first-of-type")
  private WebElement subtitle;

  @FindBy(id = "add-contact")
  private WebElement addContactButton;

  @FindBy(css = "table.contactTable")
  private WebElement contactTable;

  @FindBy(css = "tr.contactTableBodyRow")
  private List<WebElement> contactsRows;

  @FindBy(css = "tr.contactTableBodyRow > td:nth-child(2)")
  private List<WebElement> fullNameRows;

  @FindBy(css = "tr.contactTableBodyRow > td:nth-child(3)")
  private List<WebElement> birthdateRows;

  @FindBy(css = "tr.contactTableBodyRow > td:nth-child(4)")
  private List<WebElement> emailRows;

  @FindBy(css = "tr.contactTableBodyRow > td:nth-child(5)")
  private List<WebElement> phoneRows;

  @FindBy(css = "tr.contactTableBodyRow > td:nth-child(6)")
  private List<WebElement> fullAddressRows;

  @FindBy(css = "tr.contactTableBodyRow > td:nth-child(7)")
  private List<WebElement> cityStateProvinceRows;

  @FindBy(css = "tr.contactTableBodyRow > td:nth-child(8)")
  private List<WebElement> countryRows;

  @FindBy(id = "logout")
  private WebElement logout;
}
