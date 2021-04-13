Feature: Test Tiltle on the GitHub page

  @GithubTest
  Scenario: validate Heading on GitHub  page
    Given check the Chrome browser is open
    When navigate to Wikipedia home page
    Then validate heading text
