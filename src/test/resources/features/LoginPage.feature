@login
Feature: Users should be able to login

  Background: User is already in the log in page
    Given the user on the login page


  Scenario Outline: Verify login with different user types
    Given user use username as "<username>" and passcode "<password>"
    And user click the login button
    Then verify the user should be at the dashboard page
    Examples:
      | username | password    |
      | user7    | Userpass123 |
      | user34   | Userpass123 |
      | user99   | Userpass123 |



  Scenario Outline: Verify user login fail with invalid credentials
    When user use username as "<username>" and passcode "<password>"
    And user click the login button
    Then verify "<message>" message should be displayed
    Examples:
      | username | password    | message                     |
      | User9    | Wrong       | Wrong username or password. |
      | Wrong    | Userpass123 | Wrong username or password. |
      | Wrong    | Wrong       | Wrong username or password. |




