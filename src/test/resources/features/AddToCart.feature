Feature: Add to Cart

  Scenario: Add a product to the cart
    Given I am on the Edenrobe homepage
    When I search for "shirt"
    And I select a product from the search results
    And I add the product to the cart
    Then I should see the product in the cart

  Scenario: Remove a product from the cart
    Given I have a product in my cart
    When I remove the product from the cart
    Then I should see an empty cart message

  Scenario: Update the quantity of a product in the cart
    Given I have a product in my cart
    When I update the quantity of the product to 2
    Then I should see the quantity updated in the cart to 2
    And I should see the total price updated to * 2

  Scenario: View the cart
    Given I have a product in my cart
    When I view the cart
    Then I should see the product details in the cart
