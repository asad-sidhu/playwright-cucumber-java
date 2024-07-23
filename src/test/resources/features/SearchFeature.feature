Feature: Search functionality on Edenrobe.com

  Scenario: Search for a valid product
    Given I am on the Edenrobe homepage
    When I search for "shirt"
    Then I should see results related to "shirt"

  Scenario: Search for an invalid product
    Given I am on the Edenrobe homepage
    When I search for "nonexistentproduct"
    Then I should see a "no results found " message

  Scenario: Search with special characters
    Given I am on the Edenrobe homepage
    When I search for "@#$%^43432"
    Then I should see a "no results found" message

  Scenario: Search with a single character
    Given I am on the Edenrobe homepage
    When I search for "a"
    Then I should see results related to "a"

  Scenario: Search with numeric values
    Given I am on the Edenrobe homepage
    When I search for "12345"
    Then I should see a "no results found" message

  Scenario: Search with a product category
    Given I am on the Edenrobe homepage
    When I search for "men"
    Then I should see results related to "men"

  Scenario: Search with a brand name
    Given I am on the Edenrobe homepage
    When I search for "edenrobe"
    Then I should see results related to "edenrobe"

  Scenario: Search with mixed case sensitivity
    Given I am on the Edenrobe homepage
    When I search for "ShIrT"
    Then I should see results related to "ShIrT"

  Scenario: Search with a partial product name
    Given I am on the Edenrobe homepage
    When I search for "shi"
    Then I should see results related to "shi"
