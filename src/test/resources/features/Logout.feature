
@FLT-1806
Feature: fleetGru logout function
  As a user, I should be able to log out

  //@FLT-1793
  Background: User is expected to be on login page
    Given User is on the login page

  @FLT-1803
  Scenario: Log out as driver
    When User logs in with below credentials
      | username | user1       |
      | password | UserUser123 |
    And User logs out homepage
    Then User returns login page

  @FLT-1803
  Scenario: Log out as store manager
    When User logs in with below credentials
      | username | storemanager51 |
      | password | UserUser123    |
    And User logs out homepage
    Then User returns login page

  @FLT-1803
  Scenario: Log out as sales manager
    When User logs in with below credentials
      | username | salesmanager101 |
      | password | UserUser123     |
    And User logs out homepage
    Then User returns login page

  @FLT-1804
  Scenario: Once logout browsers go back button non-functional for re-login
      When User logs in with below credentials
        | username | user1       |
        | password | UserUser123 |
      And User logs out homepage
      And User clicks go back button
      Then User returns login page

  @FLT-1805
  Scenario: Closing tab or windows logs out the user
    When User logs in with below credentials
          | username | user1       |
          | password | UserUser123 |
    And User close the tab
    And User opens application on a new tab
    Then User returns login page

