@feature
Feature: Feature to Snapdeal HomePage functionality

  @smoke
  Scenario Outline: Verification for Snapdeal order funcationality
    Given user is on Home Page and verify page title
    When user click on search box
    When user has enter "<Search_product_1>" in search box
    Then user has click on search button
    Then user can click on product
    Then user switch on new window
    Then user add to cart product
    #Then user switch back to parent window
    #When user has enter "<Search_product_2>" in search box
    #Then user has click on search button
    #Then user can click on product
    #Then user switch on new window
    #Then user add to cart product
    #Then user switch back to parent window
    #When user has enter "<Search_product_3>" in search box
    #Then user has click on search button
    #Then user can click on product
    #Then user switch on new window
    #Then user add to cart product
    #Then user click on View cart
    Then user click on proceed to checkout
    Then user click on login via gmail option
    Then user login via gmail
    Then user has add delivery address
    Then user has review order
    Then user has make payment as COD

    Examples: 
      | Search_product_1 | Search_product_2   | Search_product_3 |
      | pin              | sony sound speaker | laptop bag       |
      
      
      
  @smokenew
  Scenario: Verification for Snapdeal order Email Functionality
      Given user login through gmail 
      When gmail through login and verify email
      
      
      
       
     
