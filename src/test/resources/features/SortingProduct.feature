Feature: Sorting product

  Scenario Outline: Sorting product by
    Given I am logged in as general user
    And I am on the inventory page
    When I sort the product by "<sort_method>"
    Then Sort menu shows "<sort_method>"
    And Product sorted by "<sort_method>"
    Examples:
    |sort_method|
    |Price (high to low)|