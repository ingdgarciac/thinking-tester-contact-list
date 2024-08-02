package com.herokuapp.ui.tasks;

import static com.herokuapp.utils.DeviceActions.clear;
import static com.herokuapp.utils.DeviceActions.click;
import static com.herokuapp.utils.DeviceActions.sendKeys;

import com.herokuapp.api.dtos.ContactDto;
import com.herokuapp.ui.screens.AddOrEditContactScreen;
import com.herokuapp.utils.DataContext;
import io.qameta.allure.Step;
import net.datafaker.Faker;
import net.datafaker.providers.base.Address;
import net.datafaker.providers.base.Name;

public class AddOrEditContactTasks extends AddOrEditContactScreen {

  private final Faker faker = new Faker();

  @Step("Add new contact info data")
  public AddOrEditContactTasks setNewContactInfo() {
    ContactDto contact = getContactInfo();
    sendKeys(getFirstName(), contact.getFirstName());
    sendKeys(getLastName(), contact.getLastName());
    sendKeys(getBirthDate(), contact.getDateOfBirth());
    sendKeys(getEmail(), contact.getEmail());
    sendKeys(getPhone(), contact.getPhone());
    sendKeys(getStreet1(), contact.getAddress1());
    sendKeys(getStreet2(), contact.getAddress2());
    sendKeys(getCity(), contact.getCity());
    sendKeys(getState(), contact.getProvince());
    sendKeys(getPostalCode(), contact.getPostalCode());
    sendKeys(getCountry(), contact.getCountry());
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

  @Step("Update contact data")
  public void updateContactData() {
    String birthDate = faker.date().birthday("yyyy-MM-dd");
    String email = faker.internet().emailAddress();
    String phone = faker.numerify("##########");
    sendKeys(clear(getBirthDate(), "birthdate"), birthDate);
    sendKeys(clear(getEmail(), "email"), email);
    sendKeys(clear(getPhone(), "phone"), phone);
    DataContext.getContacts().getFirst().setDateOfBirth(birthDate);
    DataContext.getContacts().getFirst().setEmail(email);
    DataContext.getContacts().getFirst().setPhone(phone);
  }
}
