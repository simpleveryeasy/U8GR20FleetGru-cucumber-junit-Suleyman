@wip
Feature: fleetGru login function
  As a user, I should be able to log in

  Background: User is expected to be on login page
    Given User is on the login page

  Scenario: Log in as driver
    When User logs in with below credentials
      | username | user1       |
      | password | UserUser123 |
    Then User is on the "Quick Launchpad" page

  Scenario: Log in as store manager
    When User logs in with below credentials
      | username | storemanager51 |
      | password | UserUser123    |
    Then User is on the "Dashboard" page

  Scenario: Log in as sales manager
    When User logs in with below credentials
      | username | salesmanager101 |
      | password | UserUser123     |
    Then User is on the "Dashboard" page



