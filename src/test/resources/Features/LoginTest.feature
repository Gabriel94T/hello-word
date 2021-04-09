Feature: Test Login functionality

  @ExTestWithTable
  Scenario Outline: Check login is succesful with valid credential
    Given browser is open
    And user is on example login page
    When user enters "<SheetName>" and <RowNumber>
    And user click on login button and fill out the form
    Then user is navigate to home page

    Examples: 
      | SheetName | RowNumber |
      | Login     |         0 |
      | Login     |         1 |
      | Login     |         2 |
      | Login     |         3 |
