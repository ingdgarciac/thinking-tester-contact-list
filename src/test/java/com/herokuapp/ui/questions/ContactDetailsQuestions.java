package com.herokuapp.ui.questions;

import static com.herokuapp.enums.Timeout.MEDIUM_TIME;
import static com.herokuapp.utils.WaitActions.waitUntilElementIsVisible;

import com.herokuapp.api.dtos.ContactDto;
import com.herokuapp.ui.screens.ContactDetailsScreen;
import com.herokuapp.utils.Assertion;
import com.herokuapp.utils.DataContext;
import io.qameta.allure.Step;

public class ContactDetailsQuestions extends ContactDetailsScreen {

  @Step("Validate contact detail screen")
  public void validateScreen() {
    waitUntilElementIsVisible(getFirstName(), MEDIUM_TIME);
    ContactDto contact = DataContext.getContacts().getFirst();
    Assertion.softAssert("First name is equal", getFirstName().getText(), contact.getFirstName());
    Assertion.softAssert("Last name is equal", getLastName().getText(), contact.getLastName());
    Assertion.softAssert(
        "Date of birth is equal", getBirthDate().getText(), contact.getDateOfBirth());
    Assertion.softAssert("Email is equal", getEmail().getText(), contact.getEmail());
    Assertion.softAssert("Phone is equal", getPhone().getText(), contact.getPhone());
    Assertion.softAssert("Street 1 is equal", getStreet1().getText(), contact.getAddress1());
    Assertion.softAssert("Street 2 is equal", getStreet2().getText(), contact.getAddress2());
    Assertion.softAssert("City is equal", getCity().getText(), contact.getCity());
    Assertion.softAssert("State is equal", getState().getText(), contact.getProvince());
    Assertion.softAssert(
        "Postal code is equal", getPostalCode().getText(), contact.getPostalCode());
    Assertion.softAssert("Country is equal", getCountry().getText(), contact.getCountry());
    Assertion.softAssert(
        "Edit contact button is visible", getEditContactButton().isDisplayed(), true);
    Assertion.softAssert("Delete button is visible", getDeleteButton().isDisplayed(), true);
    Assertion.softAssert("Return button is visible", getReturnButton().isDisplayed(), true);
    Assertion.softAssert("Logout button is visible", getLogoutButton().isDisplayed(), true);
  }
}
