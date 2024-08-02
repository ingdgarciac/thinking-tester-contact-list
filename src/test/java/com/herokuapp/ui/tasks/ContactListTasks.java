package com.herokuapp.ui.tasks;

import static com.herokuapp.utils.DeviceActions.click;

import com.herokuapp.ui.screens.ContactListScreen;
import io.qameta.allure.Step;

public class ContactListTasks extends ContactListScreen {

  @Step("Click on add contact button in Contact list screen")
  public void clickOnAddNewContact() {
    click(getAddContactButton(), "Add contact button");
  }

  @Step("Click on available contact")
  public void clickOnAvailableContact() {
    getFullNameRows().stream()
        .findFirst()
        .orElseThrow(() -> new RuntimeException("Element not found"))
        .click();
  }

  @Step("Click on logout button")
  public void clickOnLogout() {
    click(getLogout(), "Logout button");
  }
}
