package com.herokuapp.ui.tasks;

import static com.herokuapp.utils.DeviceActions.click;
import static com.herokuapp.utils.DeviceActions.sendKeys;

import com.herokuapp.api.dtos.ContactDto;
import com.herokuapp.ui.screens.AddContactScreen;
import com.herokuapp.utils.DataContext;
import io.qameta.allure.Step;
import net.datafaker.Faker;
import net.datafaker.providers.base.Address;
import net.datafaker.providers.base.Name;

public class AddContactTasks extends AddContactScreen {

  private final Faker faker = new Faker();

  @Step("Add new contact info data")
  public AddContactTasks setNewContactInfo() {
    ContactDto contact = getContactInfo();
    sendKeys(getInputFirstName(), contact.getFirstName());
    sendKeys(getInputLastName(), contact.getLastName());
    sendKeys(getInputBirthDate(), contact.getDateOfBirth());
    sendKeys(getInputEmail(), contact.getEmail());
    sendKeys(getInputPhone(), contact.getPhone());
    sendKeys(getInputStreet1(), contact.getAddress1());
    sendKeys(getInputStreet2(), contact.getAddress2());
    sendKeys(getInputCity(), contact.getCity());
    sendKeys(getInputState(), contact.getProvince());
    sendKeys(getInputPostalCode(), contact.getPostalCode());
    sendKeys(getInputCountry(), contact.getCountry());
    DataContext.getContacts().add(contact);
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
    click(getSubmitButton(), "Submit button");
  }
}
