package com.herokuapp.ui.questions;

import static com.herokuapp.enums.PageText.HEADER_CONTACT;
import static com.herokuapp.enums.PageText.SUBTITLE_CONTACT;
import static com.herokuapp.enums.Timeout.MEDIUM_TIME;
import static com.herokuapp.utils.WaitActions.waitUntilElementIsVisible;
import static org.apache.commons.lang3.StringUtils.SPACE;

import com.herokuapp.api.dtos.ContactDto;
import com.herokuapp.ui.screens.ContactListScreen;
import com.herokuapp.utils.Assertion;
import com.herokuapp.utils.DataContext;
import io.qameta.allure.Step;
import java.util.List;

public class ContactListQuestions extends ContactListScreen {

  @Step("Validate contact list screen")
  public void validateScreen() {
    waitUntilElementIsVisible(getHeaderTitle(), MEDIUM_TIME);
    Assertion.softAssert("Header title is visible", getHeaderTitle().isDisplayed(), true);
    Assertion.softAssert("Header title text", getHeaderTitle().getText(), HEADER_CONTACT.getText());
    Assertion.softAssert("Subtitle is visible", getSubtitle().isDisplayed(), true);
    Assertion.softAssert("Subtitle text", getSubtitle().getText(), SUBTITLE_CONTACT.getText());
    Assertion.softAssert(
        "Add new contact button is visible", getAddContactButton().isDisplayed(), true);
    Assertion.softAssert("Contacts table is visible", getContactTable().isDisplayed(), true);
  }

  @Step("Validate new contact")
  public void validateNewContact() {
    waitUntilElementIsVisible(getContactTable(), MEDIUM_TIME);
    Assertion.softAssert("Contacts table is visible", getContactTable().isDisplayed(), true);
    Assertion.hardAssert("Contacts size is 1", getContactsRows().size(), 1);
  }

  @Step("Validate contact info")
  public void validateContactInfo() {
    List<ContactDto> contacts = DataContext.getContacts();
    for (int i = 0; i < contacts.size(); i++) {
      String fullName =
          contacts.get(i).getFirstName().concat(SPACE).concat(contacts.get(i).getLastName());
      String fullAddress =
          contacts.get(i).getAddress1().concat(SPACE).concat(contacts.get(i).getAddress2());
      String fullLocation =
          contacts
              .get(i)
              .getCity()
              .concat(SPACE)
              .concat(contacts.get(i).getProvince())
              .concat(SPACE)
              .concat(contacts.get(i).getPostalCode());
      Assertion.hardAssert("Full name is equal", getFullNameRows().get(i).getText(), fullName);
      Assertion.hardAssert(
          "Birthday is equal",
          getBirthdateRows().get(i).getText(),
          contacts.get(i).getDateOfBirth());
      Assertion.hardAssert(
          "Email is equal", getEmailRows().get(i).getText(), contacts.get(i).getEmail());
      Assertion.hardAssert(
          "Phone is equal", getPhoneRows().get(i).getText(), contacts.get(i).getPhone());
      Assertion.hardAssert("Address is equal", getFullAddressRows().get(i).getText(), fullAddress);
      Assertion.hardAssert(
          "City/State/Province is equal",
          getCityStateProvinceRows().get(i).getText(),
          fullLocation);
      Assertion.hardAssert(
          "Country is equal", getCountryRows().get(i).getText(), contacts.get(i).getCountry());
    }
  }
}
