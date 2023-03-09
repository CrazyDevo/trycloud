Feature: As a user, I should be able to access to Files module.

# We can create  a Background:  in here a nd use it

  Scenario: verify users can access to Files module
    Given the users  log in with valid credentials
    When the user clicks the "Files" module
    Then verify the page title is "Files - Trycloud"


  Scenario: verify users can select all the uploaded files from the page
    Given the users  log in with valid credentials
    When the user clicks the "Files" module
    And user click the top-left checkbox of the table
    Then verify all the files are selected


  Scenario: Verify users to add files to Favorites
    Given the users  log in with valid credentials
    When the user clicks the "Files" module
    When the user clicks action-icon  from any file on the page
    And user choose the "Add to favorites" option
    And user click the "Favorites" sub-module on the left side
    Then Verify the chosen file is listed on the table
    When the user Remove the files from Favorites


  Scenario: verify users to remove files to Favorites
    Given the users  log in with valid credentials
    When the user clicks the "Files" module
    When the user clicks action-icon  from any file on the page
    And user choose the "Add to favorites" option
    And user click the "Favorites" sub-module on the left side
    And the user Remove the files from Favorites
    Then Verify that the file is not listed in the Favorites table


  Scenario: verify users to upload a file from Files
    Given the users  log in with valid credentials
    When the user clicks the "Files" module
    When the user clicks the add icon on the top
    And users uploads file with the "Upload file" option
    Then verify the file is displayed on the page
    When the user clicks action-icon  from "fileUpload" file on the page
    And user choose the "Delete file" option


  Scenario: Verify users can add the folder
    Given the users  log in with valid credentials
    When the user clicks the "Files" module
    When the user clicks the add icon on the top
    And users uploads file with the "New folder" option
    And user write a folder name
    When the user click submit icon
    Then Verify the folder is displayed on the page
    When the user clicks action-icon  from "test" file on the page
    And user choose the "Delete folder" option


  Scenario: Verify users delete a file
    Given the users  log in with valid credentials
    When the user clicks the "Files" module
    When the user clicks the add icon on the top
    And users uploads file with the "Upload file" option
    When the user clicks action-icon  from "fileUpload" file on the page
    And user choose the "Delete file" option
    Then verify the file is not displayed on the page


  Scenario:  Verify users delete a folder
    Given the users  log in with valid credentials
    When the user clicks the "Files" module
    When the user clicks the add icon on the top
    And users uploads file with the "New folder" option
    And user write a folder name
    When the user click submit icon
    When the user clicks action-icon  from "test" file on the page
    And user choose the "Delete folder" option
    Then Verify the folder is not displayed on the page


  Scenario: verify users to upload a file from Files
    Given the users  log in with valid credentials
    When the user clicks the "Files" module
    When the user clicks the add icon on the top
    And users uploads file with the "Upload file" option
    When the user clicks action-icon  from "fileUpload" file on the page
    And user choose the "Details" option
    And user clicks the "Comments" option
    And user write a comment as "Test" inside the input box
    And user click the submit button to post it
    Then Verify the comment is displayed in the comment section
    When the user clicks action-icon  from "fileUpload" file on the page
    And user choose the "Delete file" option


  Scenario: Verify the users can check any checkbox on the Files page.
    Given the users  log in with valid credentials
    When the user clicks the "Files" module
    And user clicks Settings on the left bottom corner
    Then the user should be able to click any checkbox


