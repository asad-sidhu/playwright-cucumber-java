Feature: Restaurant Search
  As a user
  I want to search for restaurants
  So that I can find the food I want

  Scenario: Verify location search by name
    Given I am on the Uber Eats homepage
    When I search for a location by name "Etihad Stadium"
    Then the location "Etihad Stadium" should appear in the search results
    And I should be able to select the location "Etihad Stadium" in the Address Label

  Scenario: Verify restaurant search by name
    Given I am on the Uber Eats homepage
    When I search for a restaurant by name "Pizza Place"
    Then the restaurant "Pizza Place" should appear in the search results

  Scenario: Verify restaurant search by cuisine type
    Given I am on the Uber Eats homepage
    When I search for restaurants by cuisine type "Italian"
    Then restaurants offering "Italian" cuisine should appear in the search results

  Scenario: Verify search results for multiple cuisines
    Given I am on the Uber Eats homepage
    When I search for restaurants by multiple cuisine types "Italian" and "Chinese"
    Then restaurants offering "Italian" or "Chinese" cuisine should appear in the search results

  Scenario: Verify restaurant search by location
    Given I am on the Uber Eats homepage
    When I search for restaurants in location "New York"
    Then restaurants in "New York" should appear in the search results

  Scenario: Verify sorting by rating
    Given I have searched for restaurants
    When I sort the results by rating
    Then restaurants should be listed in descending order of their ratings

  Scenario: Verify sorting by delivery time
    Given I have searched for restaurants
    When I sort the results by delivery time
    Then restaurants should be listed in ascending order of their estimated delivery times

  Scenario: Verify filtering by price range
    Given I have searched for restaurants
    When I filter the results by price range "$$"
    Then restaurants within the price range "$$" should appear in the search results

  Scenario: Verify filtering by restaurant type
    Given I have searched for restaurants
    When I filter the results by restaurant type "Fast Food"
    Then restaurants of the type "Fast Food" should appear in the search results

  Scenario: Verify no results found for invalid search
    Given I am on the Uber Eats homepage
    When I search for a restaurant by name "NonExistentPlace"
    Then a message indicating no results found should be displayed

  Scenario: Verify search results for popular restaurants
    Given I am on the Uber Eats homepage
    When I search for popular restaurants
    Then popular restaurants with high ratings should appear in the search results
