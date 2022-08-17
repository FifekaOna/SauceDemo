Feature: Log in to Page

  Scenario Outline: Success logged in as normal user
    Given I am on the login Page
    When I fill user name with "<username>"
    And I fill password with "<password>"
    And I click login button
    Then I am directed to inventory page
    Examples:
    |username|password|
    |standard_user|secret_sauce|