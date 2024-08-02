package com.herokuapp.ui.tasks;

import com.herokuapp.ui.screens.ContactListScreen;
import io.qameta.allure.Step;

public class ContactListTasks extends ContactListScreen {

  @Step("Click on add contact button in Contact list screen")
  public void clickOnAddNewContact() {
    getAddContactButton().click();
  }
}
