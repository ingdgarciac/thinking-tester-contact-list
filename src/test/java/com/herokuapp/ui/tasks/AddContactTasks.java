package com.herokuapp.ui.tasks;

import com.herokuapp.api.dtos.ContactDto;
import com.herokuapp.ui.screens.AddContactScreen;
import com.herokuapp.utils.UserInfo;
import io.qameta.allure.Step;
import net.datafaker.Faker;
import net.datafaker.providers.base.Address;
import net.datafaker.providers.base.Name;

public class AddContactTasks extends AddContactScreen {

  private final Faker faker = new Faker();

  @Step("Add new contact info data")
  public AddContactTasks setNewContactInfo() {
    ContactDto contact = getContactInfo();
    getInputFirstName().sendKeys(contact.getFirstName());
    getInputLastName().sendKeys(contact.getLastName());
    getInputBirthDate().sendKeys(contact.getDateOfBirth());
    getInputEmail().sendKeys(contact.getEmail());
    getInputPhone().sendKeys(contact.getPhone());
    getInputStreet1().sendKeys(contact.getAddress1());
    getInputStreet2().sendKeys(contact.getAddress2());
    getInputCity().sendKeys(contact.getCity());
    getInputState().sendKeys(contact.getProvince());
    getInputPostalCode().sendKeys(contact.getPostalCode());
    getInputCountry().sendKeys(contact.getCountry());
    UserInfo.getContacts().add(contact);
    return this;
  }

  private ContactDto getContactInfo() {
    Address address = faker.address();
    Name name = faker.name();
    return ContactDto.builder()
        .firstName(name.firstName())
        .lastName(name.lastName())
        .dateOfBirth(faker.date().birthday("yyyy-MM-dd"))
        .email(faker.internet().emailAddress())
        .phone(faker.numerify("##########"))
        .address1(address.streetAddress())
        .address2(address.secondaryAddress())
        .city(address.city())
        .province(address.state())
        .postalCode(address.postcode())
        .country(address.country())
        .build();
  }

  @Step("Submit the contact information")
  public void clickOnSubmit() {
    getSubmitButton().click();
  }
}
