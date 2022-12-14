@Checkout
Feature: ordering Product

  @CheckoutPositive
  Scenario Outline: User order first product on the list
    Given I am logged in as general user
    And My cart is empty
    And I am on the inventory page
    And Product is sorted with "<sort_method>"
    When I click the first product on the list
    Then Product with "<product_name>" and "<product_price>" detail opened
    When I click add to cart button
    And I click cart icon
    Then "<product_name>" is on the cart list with price "<product_price>"
    When I click checkout button
    Then Buyer data form appear
    When I fill my data with "<first_name>","<last_name>" and "<ZIP>"
    Then Shopping list appear with "<product_name>" which price "<product_price>"
    When I click finish button
    Then Order process completed
    Examples:
      | sort_method         | product_name             | product_price | first_name | last_name | ZIP   |
      | Price (high to low) | Sauce Labs Fleece Jacket | $49.99        | fifeka     | onanda    | 27512 |