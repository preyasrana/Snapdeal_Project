@feature
Feature: Feature to Snapdeal HomePage functionality

  @Regression
  Scenario: Verify user should be redirect on changepassword page or not
    Given user is on Home Page and verify page title
    When user click on login Section
    Then user redirect on Login popup
    Then user logining via gmail
    Then user click on order section
    Then user click on changepassword link
    Then Verify Page Should be Redirect on changepassword page
    
  @Smoke
  Scenario: Verify Without entering changepassword user cant submit 
    Given user is on Home Page and verify page title
    When user click on login Section
    Then user redirect on Login popup
    Then user logining via gmail
    Then user click on order section
    Then user click on changepassword link
    Then user click on submit button & Verify Error message 
     



    