package com.herokuapp.ui.tasks;

import static com.herokuapp.utils.DeviceActions.click;
import static com.herokuapp.utils.WaitActions.waitUntilAlertIsVisible;

import com.herokuapp.ui.screens.ContactDetailsScreen;
import io.qameta.allure.Step;

public class ContactDetailsTasks extends ContactDetailsScreen {

  @Step("Click on edit contact button")
  public void clickOnEditButton() {
    click(getEditContactButton(), "Edit contact button");
  }

  @Step("Click on contact list button")
  public void clickOnReturnToContactList() {
    click(getReturnButton(), "Return to contact list button");
  }

  @Step("Click on delete button")
  public void clickOnDeleteButton() {
    click(getDeleteButton(), "Delete contact button");
  }

  @Step("Click on confirm alert")
  public void confirmDelete() {
    waitUntilAlertIsVisible().accept();
  }
}
