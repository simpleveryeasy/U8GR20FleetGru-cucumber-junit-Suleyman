
@FLT-1802
Feature: fleetGru login function
  As a user, I should be able to log in

  //@FLT-1793
  Background: User is expected to be on login page
    Given User is on the login page

  @FLT-1794
  Scenario: Log in as driver
    When User logs in with below credentials
      | username | user1       |
      | password | UserUser123 |
    Then User is on the "Quick Launchpad" page

  @FLT-1794
  Scenario: Log in as store manager
    When User logs in with below credentials
      | username | storemanager51 |
      | password | UserUser123    |
    Then User is on the "Dashboard" page

  @FLT-1794
  Scenario: Log in as sales manager
    When User logs in with below credentials
      | username | salesmanager101 |
      | password | UserUser123     |
    Then User is on the "Dashboard" page

  @FLT-1795
  Scenario: Log in with invalid credentials
      When User logs in with below credentials
        | username | user1   |
        | password | invalid |
      Then User sees "Invalid user name or password."

  @FLT-1795
  Scenario: Log in with invalid credentials
    When User logs in with below credentials
      | username | invalid |
      | password | UserUser123 |
    Then User sees "Invalid user name or password."

  @FLT-1796
  Scenario: Log in with missing credentials
    When User enters username "user1"
    And User press login button
    Then User sees "Please fill out this field" under username input box

  @FLT-1796
  Scenario: Log in with missing credentials
    When User enters password "UserUser123"
    And User press login button
    Then User sees "Please fill out this field" under password input box

  @FLT-1797
  Scenario: Forgot password link functionality
    When User clicks Forgot your password? link
    Then User is on the Forgot Password page

  @FLT-1798
  Scenario: Remember me checkbox functionality
    When User sees Remember Me link
    Then User sees Remember Me link clickable

  @FLT-1799
  Scenario: Password input masked
    When User enters password "UserUser123"
    Then User sees bullet signs

  @FLT-1800
  Scenario: Enter key functionality
    When User enters username "user1"
    And User enters password "UserUser123"
    And User press Enter key
    Then User is on the "Quick Launchpad" page

  @FLT-1801
  Scenario: User sees own username on the homepage profile
    When User logs in with below credentials
      | username | user1       |
      | password | UserUser123 |
    Then User sees "user1" on the profile

  @FLT-1801
  Scenario: User sees own username on the homepage profile
    When User logs in with below credentials
      | username | storemanager51 |
      | password | UserUser123    |
    Then User sees "storemanager51" on the profile










