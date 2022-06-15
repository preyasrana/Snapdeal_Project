@feature
Feature: Feature to Snapdeal HomePage functionality

  @smoke
  Scenario: Verification for Snapdeal ChangePassword funcationality
    Given user is on Home Page and verify page title
    When user click on login Section
    Then user redirect on Login popup
    Then user logining via gmail
    Then user click on order section

    