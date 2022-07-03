
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

    Scenario: Log in with invalid credentials
      When User logs in with below credentials
        | username | user1   |
        | password | invalid |
      Then User sees "Invalid user name or password."

  Scenario: Log in with invalid credentials
    When User logs in with below credentials
      | username | invalid |
      | password | UserUser123 |
    Then User sees "Invalid user name or password."

  Scenario: Log in with missing credentials
    When User enters username "user1"
    And User press login button
    Then User sees "Please fill out this field" under username input box

  Scenario: Log in with missing credentials
    When User enters password "UserUser123"
    And User press login button
    Then User sees "Please fill out this field" under password input box

  Scenario: Forgot password link functionality
    When User clicks Forgot your password? link
    Then User is on the Forgot Password page

  Scenario: Remember me checkbox functionality
    When User sees Remember Me link
    Then User sees Remember Me link clickable


  Scenario: Password input masked
    When User enters password "UserUser123"
    Then User sees bullet signs

  Scenario: Enter key functionality
    When User enters username "user1"
    And User enters password "UserUser123"
    And User press Enter key
    Then User is on the "Quick Launchpad" page

  Scenario: User sees own username on the homepage profile
    When User logs in with below credentials
      | username | user1       |
      | password | UserUser123 |
    Then User sees "user1" on the profile

  Scenario: User sees own username on the homepage profile
    When User logs in with below credentials
      | username | storemanager51 |
      | password | UserUser123    |
    Then User sees "storemanager51" on the profile










