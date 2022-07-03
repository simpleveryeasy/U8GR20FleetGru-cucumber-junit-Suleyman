@wip
Feature: fleetGru logout function
  As a user, I should be able to log out

  Background: User is expected to be on login page
    Given User is on the login page

  Scenario: Log out as driver
    When User logs in with below credentials
      | username | user1       |
      | password | UserUser123 |
    And User logs out homepage
    Then User returns login page

  Scenario: Log out as store manager
    When User logs in with below credentials
      | username | storemanager51 |
      | password | UserUser123    |
    And User logs out homepage
    Then User returns login page


  Scenario: Log out as sales manager
    When User logs in with below credentials
      | username | salesmanager101 |
      | password | UserUser123     |
    And User logs out homepage
    Then User returns login page

    Scenario: Once logout browsers go back button non-functional for re-login
      When User logs in with below credentials
        | username | user1       |
        | password | UserUser123 |
      And User logs out homepage
      And User clicks go back button
      Then User returns login page

      Scenario: Closing tab or windows logs out the user
        When User logs in with below credentials
          | username | user1       |
          | password | UserUser123 |
        And User close the tab
        And User opens application on a new tab
        Then User returns login page

