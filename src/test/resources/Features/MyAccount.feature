@feature
Feature: Feature to Snapdeal HomePage functionality

  @Regression1
  Scenario: Verify user should be redirect on changepassword page or not
    Given user is on Home Page and verify page title
    When user click on login Section
    Then user redirect on Login popup
    Then user logining via gmail
    Then user click on order section
    Then user click on changepassword link
    Then Verify Page Should be Redirect on changepassword page

  @Smoke1
  Scenario: Verify Without entering changepassword user cant changepasword & verify validation mesage
    Given user is on Home Page and verify page title
    When user click on login Section
    Then user redirect on Login popup
    Then user logining via gmail
    Then user click on order section
    Then user click on changepassword link
    Then user click on submit button & Verify Error message

  @Regression1
  Scenario Outline: Verify Invalid password functionality (password should not have atleast 6 characters)
    Given user is on Home Page and verify page title
    When user click on login Section
    Then user redirect on Login popup
    Then user logining via gmail
    Then user click on order section
    Then user click on changepassword link
    Then user enter "<invalidnewpassword>" & Verify "<error_message>"

    Examples: 
      | invalidnewpassword | error_message                                |
      | test               | Password length must be minimum 6 characters |

  @Smoke
  Scenario Outline: Verify valid newpassword functionality
    Given user is on Home Page and verify page title
    When user click on login Section
    Then user redirect on Login popup
    Then user logining via gmail
    Then user click on order section
    Then user click on changepassword link
    Then user enter "<validnewpassword>" & click on submit button
    #  Then otp popup display & user enter otp
    
    
    Examples: 
      | validnewpassword |
      | test123          |
