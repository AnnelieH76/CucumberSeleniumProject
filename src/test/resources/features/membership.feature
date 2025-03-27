Feature: Membership

  Scenario:  Create an account with success
    Given I have used "edge" to navigate to website basketball england membership
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


  Scenario:  Create an account, last name missing
    Given I have used "edge" to navigate to website basketball england membership
    When I add date of birth
    And I add First Name
    #And I add Last Name
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


  Scenario:  Create an account, forget Terms and Conditions
    Given I have used "edge" to navigate to website basketball england membership
    When I add date of birth
    And I add First Name
    And I add Last Name
    And I add email address
    And I confirm email adress
    And I add password
    And I retype password
    And I click Fan
    #And I click I have read the Terms and Conditions
    And I click I am aged over "18"
    And I click I have read Code of Ethics and Conduct
    And I click button Confirm and join
    Then I should see the error text "You must confirm that you have read and accepted our Terms and Conditions"


  Scenario:  Create an account, retype wrong password
    Given I have used "edge" to navigate to website basketball england membership
    When I add date of birth
    And I add First Name
    And I add Last Name
    And I add email address
    And I confirm email adress
    And I add password
    And I retype wrong password
    And I click Fan
    And I click I have read the Terms and Conditions
    And I click I am aged over "18"
    And I click I have read Code of Ethics and Conduct
    And I click button Confirm and join
    Then I should see error message "Password did not match"

  Scenario Outline:  Create an account with Senario Outline
    Given I have used "chrome" to navigate to website basketball england membership
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
    Then I get the result <result>

    Examples:
      | first   | last       | password | retype   | result    |
      | "Anna"  | "Alm"      | "abc111" | "abc111" | "success" |
      | "Bo"    | ""         | "abc222" | "abc222" | "error"   |
      | "Cilla" | "Carlsson" | "abc333" | "abcdef" | "error"   |

