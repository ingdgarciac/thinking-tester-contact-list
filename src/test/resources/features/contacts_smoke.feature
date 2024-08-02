@smoke @e2e
Feature: Contacts

  This scenario test the following functionalities:
  - Create an user account through backend services for login into the app
  - User can login into the application
  - User can create a contact
  - User can update a contact
  - User can delete a contact
  - User can logout the application
  - The created user is delete it through backend services

  Scenario: Validate contact creation, update and delete
    Given a new user of the contact list app
    And login process is completed successfully
    When the user creates a new contact
    Then the created contact appears
    When the user taps on created contact
    Then the contact details appears
    When the user initiates the edition process
    Then the contact is update it
    When the user taps on created contact
    Then the contact details appears
    When the user initiates the deletion process
    Then the contact list is empty
    When the user taps on logout
    Then login screen is shown
