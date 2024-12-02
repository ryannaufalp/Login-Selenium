Feature: Login Functionality

  @validLogin
  Scenario: Valid Login
    Given the user is on the login page
    When the user enters valid credentials
    And clicks the login button
    Then the user should be redirected to the dashboard

  @invalidLoginUsername
  Scenario: Invalid Login Username
    Given the user is on the login page invalid username
    When the user enters invalid credentials username
    And clicks the login button invalid username
    Then an error message should be displayed for username incorrect

  @invalidLoginPassword
  Scenario: Invalid Login Password
    Given the user is on the login page invalid password
    When the user enters invalid credentials password
    And clicks the login button invalid password
    Then an error message should be displayed for password incorrect
