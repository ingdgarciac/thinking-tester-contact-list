@Smoke
Feature: Contacts

  This scenario test the creation functionality of contacts in the UI

  Scenario: Contact creation
    Given a new user of the contact list app
    And login process is completed successfully
    When the user creates a new contact
    Then the created contact appears in the contact list screen