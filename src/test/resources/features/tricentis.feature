Feature: Test of Tricentis webshop

  Scenario:  Verify book
    Given I have navigated to webshop Tricentis
    When I click at Books
    Then I verify something at the webpage "Picture of Computing and Internet"

  Scenario Outline:  Verify items
    Given I have navigated to webshop Tricentis
    When I click at <categories>
    Then I verify <item> at the webpage

    Examples:
      | categories    | item                                |
      | "books"       | "Picture of Computing and Internet" |
      | "computers"   | "Picture for category Desktops"     |
      | "electronics" | "Picture for category Camera, photo"   |
