Feature: Membership

  Scenario:  Create an account
    Given I have navigated to website basketball england membership
    When I add date of birth
    And I add First Name
    And I add Last Name
    And I add email address
    And I confirm email adress
    And I add password
    And I retype password
    And I click Fan
    And I click I have read the Terms and Conditions
    And I click I am aged over "18"
    And I click I have read Code of Ethics and Conduct
    And I click button Confirm and join
    Then I get the result membership

  Scenario Outline:  Create an account with Senario Outline
    Given I have navigated to website basketball england membership
    When I add date of birth
    And I add my first name <first>
    And I add my last name <last>
    And I add email address
    And I confirm email adress
    And I add my password <password>
    And I retype my password <retype>
    And I click Fan
    And I click I have read the Terms and Conditions
    And I click I am aged over "18"
    And I click I have read Code of Ethics and Conduct
    And I click button Confirm and join
    Then I get the result membership

    Examples:
      | first   | last       | password | retype   |
      | "Anna"  | "Alm"      | "abc111" | "abc111" |
      | "Bo"    |            | "abc222" | "abc222" |
      | "Cilla" | "Carlsson" | "abc333" | "abc"    |


  Scenario:  Create an account, last name missing
    Given I have navigated to website basketball england membership
    When I add date of birth
    And I add First Name
    And I add email address
    And I confirm email adress
    And I add password
    And I retype password
    And I click Fan
    And I click I have read the Terms and Conditions
    And I click I am aged over "18"
    And I click I have read Code of Ethics and Conduct
    And I click button Confirm and join
    Then I should see the error message "Last Name is required"