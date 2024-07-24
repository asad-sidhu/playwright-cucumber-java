Feature: Product Sorting

  Scenario: Verify products are sorted in A-Z order
    Given I am on the Edenrobe products page
    When I sort the products by "A-Z"
    Then I should see products sorted in "A-Z" order

  Scenario: Verify products are sorted in Z-A order
    Given I am on the Edenrobe products page
    When I sort the products by "Z-A"
    Then I should see products sorted in "Z-A" order

  Scenario: Verify products are sorted in Price Low to High order
    Given I am on the Edenrobe products page
    When I sort the products by "Price lower to higher"
    Then I should see products sorted in "Price lower to higher" order

  Scenario: Verify products are sorted in Price High to Low order
    Given I am on the Edenrobe products page
    When I sort the products by "Price higher to lower"
    Then I should see products sorted in "Price higher to lower" order

  Scenario Outline: Verify filters are working correctly
    Given I am on the Edenrobe products page
    When I open the filter popup
    And I filter the products
      | filter   |
      | <filter> |
    Then I should see products according to the filter applied
      | filter   |
      | <filter> |

    Examples:
      | filter       |
      | Discount     |
      | Piece        |
#      | Size         |
