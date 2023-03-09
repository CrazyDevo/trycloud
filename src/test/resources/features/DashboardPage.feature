Feature: As a user, I should be accessing all the main modules of the app.



  Scenario:  Verify users accessing all the main modules of the app.
    Given the users  log in with valid credentials
    Then Verify the user see the following modules:

      | Dashboard |
      | Files     |
      | Photos    |
      | Activity  |
      | Talk      |
      | Contacts  |
      | Circles   |
      | Calendar  |
      | Deck      |



  Scenario Outline: Verify users can search any files/folder/users from the search box.
    Given the users  log in with valid credentials
    When the user clicks the magnifier icon on the right top
    And users search any existing files-folder-users "<word>" name
    Then verify the app displays the expected result option
    Examples:
      |word|
      |DONOTDELETE|
      |Read|
      |Muhtar|