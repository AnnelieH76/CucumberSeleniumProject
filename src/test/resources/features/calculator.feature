Feature: Calculator

  #Scenario: Add two numbers
   # Given I have two numbers 10 and 20
   # When I add the two numbers
   # Then I get a result 30

   # Scenario: Subtract two numbers
     # Given I have two numbers 30 and 5
     # When I subtract the two numbers
     # Then I get a result 25

  Scenario Outline: Add two numbers
    Given I have two numbers <first> and <second>
    When I <operation> the two numbers
    Then I get a <result>

    Examples:
      | first | second | operation | result |  |
      | 20.0  | 20.0   | add       | 40.0   |  |
      | 100.0 | 20.0   | add       | 120    |  |
      | 100.0 | 5      | subtract  | 95     |  |