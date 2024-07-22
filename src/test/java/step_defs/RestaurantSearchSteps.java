package step_defs;

import Misc.Constants;
import com.microsoft.playwright.Page;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.HomePage;
import pages.RestaurantSearchPage;
import utils.PlaywrightDriver;

import java.nio.file.Paths;

public class RestaurantSearchSteps {
//
    private final Page page = PlaywrightDriver.getPage();
    private final HomePage homePage = new HomePage();
    private final RestaurantSearchPage restaurantSearchPage = new RestaurantSearchPage();
    Scenario scenario;
//
////    public RestaurantSearchSteps() {
////        this.page = PlaywrightDriver.getPage();
////        this.homePage = new HomePage(page);
////        this.restaurantSearchPage = new RestaurantSearchPage(page);
////    }
//
//    @Given("I am on the Uber Eats homepage")
//    public void iAmOnTheUberEatsHomepage() {
//        try {
//            PlaywrightDriver.openPage(Constants.HOME_URL);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
    @When("I search for a location by name {string}")
    public void iSearchForALocationByName(String name) {
        try {
            homePage.searchLocationByName(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//
    @When("I search for a restaurant by name {string}")
    public void iSearchForARestaurantByName(String name) {
        try {
            homePage.searchRestaurantByName(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("I search for restaurants by cuisine type {string}")
    public void iSearchForRestaurantsByCuisineType(String cuisine) {
        try {
            homePage.searchRestaurantByCuisineType(cuisine);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("I search for restaurants by multiple cuisine types {string} and {string}")
    public void iSearchForRestaurantsByMultipleCuisineTypes(String cuisine1, String cuisine2) {
        try {
            homePage.searchRestaurantByMultipleCuisineTypes(cuisine1, cuisine2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("I search for restaurants in location {string}")
    public void iSearchForRestaurantsInLocation(String location) {
        try {
            homePage.searchRestaurantByLocation(location);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("I sort the results by rating")
    public void iSortTheResultsByRating() {
        try {
            restaurantSearchPage.sortByRating();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("I sort the results by delivery time")
    public void iSortTheResultsByDeliveryTime() {
        try {
            restaurantSearchPage.sortByDeliveryTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("I filter the results by price range {string}")
    public void iFilterTheResultsByPriceRange(String priceRange) {
        try {
            restaurantSearchPage.filterByPriceRange(priceRange);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("I filter the results by restaurant type {string}")
    public void iFilterTheResultsByRestaurantType(String restaurantType) {
        try {
            restaurantSearchPage.filterByRestaurantType(restaurantType);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("I search for popular restaurants")
    public void iSearchForPopularRestaurants() {
        try {
            homePage.searchPopularRestaurants();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("the restaurant {string} should appear in the search results")
    public void theRestaurantShouldAppearInTheSearchResults(String name) {
        try {
            Assert.assertTrue(restaurantSearchPage.isRestaurantInResults(name), "Restaurant not found in the search results: " + name);
        } catch (AssertionError | Exception e) {
            e.printStackTrace();
        }
    }

    @Then("the location {string} should appear in the search results")
    public void thelocationShouldAppearInThePredictiveSearchResults(String name) {
        try {
            Assert.assertTrue(homePage.isPredictiveSearchFunctional().contains(name), "Location not found in the search results: " + name);
        } catch (AssertionError | Exception e) {
            e.printStackTrace();
        }
    }

    @Then("I should be able to select the location {string} in the Address Label")
    public void iShouldBeAbleToSelectLocation(String name) {
        try {
            homePage.selectLocation();
            Assert.assertTrue(homePage.getDeliveryAddressLabel().contains(name), "Location not selected and shown in the address label: " + name);

        } catch (AssertionError | Exception e) {
            e.printStackTrace();
        }
    }

    @Then("restaurants offering {string} cuisine should appear in the search results")
    public void restaurantsOfferingCuisineShouldAppearInTheSearchResults(String cuisine) {
        try {
            Assert.assertTrue(restaurantSearchPage.areRestaurantsOfCuisineInResults(cuisine), "Restaurants offering cuisine not found: " + cuisine);
        } catch (AssertionError | Exception e) {
            e.printStackTrace();
        }
    }

    @Then("restaurants offering {string} or {string} cuisine should appear in the search results")
    public void restaurantsOfferingOrCuisineShouldAppearInTheSearchResults(String cuisine1, String cuisine2) {
        try {
            Assert.assertTrue(restaurantSearchPage.areRestaurantsOfMultipleCuisinesInResults(cuisine1, cuisine2), "Restaurants offering cuisines not found: " + cuisine1 + ", " + cuisine2);
        } catch (AssertionError | Exception e) {
            e.printStackTrace();
        }
    }

    @Then("restaurants in {string} should appear in the search results")
    public void restaurantsInLocationShouldAppearInTheSearchResults(String location) {
        try {
            Assert.assertTrue(restaurantSearchPage.areRestaurantsInLocationInResults(location), "Restaurants in location not found: " + location);
        } catch (AssertionError | Exception e) {
            e.printStackTrace();
        }
    }

    @Then("restaurants should be listed in descending order of their ratings")
    public void restaurantsShouldBeListedInDescendingOrderOfTheirRatings() {
        try {
            Assert.assertTrue(restaurantSearchPage.areRestaurantsSortedByRating(), "Restaurants are not sorted by rating");
        } catch (AssertionError | Exception e) {
            e.printStackTrace();
        }
    }

    @Then("restaurants should be listed in ascending order of their estimated delivery times")
    public void restaurantsShouldBeListedInAscendingOrderOfTheirEstimatedDeliveryTimes() {
        try {
            Assert.assertTrue(restaurantSearchPage.areRestaurantsSortedByDeliveryTime(), "Restaurants are not sorted by delivery time");
        } catch (AssertionError | Exception e) {
            e.printStackTrace();
        }
    }

    @Then("restaurants within the price range {string} should appear in the search results")
    public void restaurantsWithinThePriceRangeShouldAppearInTheSearchResults(String priceRange) {
        try {
            Assert.assertTrue(restaurantSearchPage.areRestaurantsInPriceRange(priceRange), "Restaurants within the price range not found: " + priceRange);
        } catch (AssertionError | Exception e) {
            e.printStackTrace();
        }
    }

    @Then("restaurants of the type {string} should appear in the search results")
    public void restaurantsOfTypeShouldAppearInTheSearchResults(String restaurantType) {
        try {
            Assert.assertTrue(restaurantSearchPage.areRestaurantsOfTypeInResults(restaurantType), "Restaurants of the type not found: " + restaurantType);
        } catch (AssertionError | Exception e) {
            e.printStackTrace();
        }
    }

    @Then("a message indicating no results found should be displayed")
    public void aMessageIndicatingNoResultsFoundShouldBeDisplayed() {
        try {
            Assert.assertTrue(restaurantSearchPage.isNoResultsMessageDisplayed(), "No results message is not displayed");
        } catch (AssertionError | Exception e) {
            e.printStackTrace();
        }
    }

    @Then("popular restaurants with high ratings should appear in the search results")
    public void popularRestaurantsWithHighRatingsShouldAppearInTheSearchResults() {
        try {
            Assert.assertTrue(restaurantSearchPage.arePopularRestaurantsInResults(), "Popular restaurants with high ratings not found");
        } catch (AssertionError | Exception e) {
            e.printStackTrace();
        }
    }

    @Given("I am on the Uber Eats homepage")
    public void the_user_is_on_the_uber_eats_homepage() {
        PlaywrightDriver.openPage(Constants.HOME_URL);
        System.out.println("hey");
    }
}
