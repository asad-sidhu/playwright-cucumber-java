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

  Scenario: Search with mixed case sensitivity
    Given I am on the Edenrobe homepage
    When I search for "ShIrT"
    Then I should see results related to "ShIrT"

  Scenario: Search with a product code
    Given I am on the Edenrobe homepage
    When I search for "EMTKS"
    Then I should see results related to "EMTKS"

  Scenario: Popular searches section
    Given I am on the Edenrobe homepage
    When I click the search button
    Then I should see the popular searches section

  Scenario: Trending Now section
    Given I am on the Edenrobe homepage
    When I click the search button
    Then I should see the trending now section

  Scenario: Exploring the popular searches
    Given I am on the Edenrobe homepage
    When I click the search button
    Then The user should be shown results according to the popular search option that user clicks

  Scenario: Exploring the trending now section
    Given I am on the Edenrobe homepage
    When I click the search button
    Then The user should be shown results according to the trending now option that user clicks


