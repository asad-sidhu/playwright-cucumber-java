
package pages;

import base.BasePage;
import com.microsoft.playwright.Page;

public class RestaurantSearchPage extends BasePage {

//    private static Page page;

    // Locators
    private static final String sortByRatingButton = "button[data-testid='sort-by-rating']";
    private static final String sortByDeliveryTimeButton = "button[data-testid='sort-by-delivery-time']";
    private static final String priceRangeFilter = "button[data-testid='price-range-filter']";
    private static final String restaurantTypeFilter = "button[data-testid='restaurant-type-filter']";
    private static final String noResultsMessage = "text=No results found";
    private static final String restaurantCard = ".restaurant-card";

//    public RestaurantSearchPage(Page page) {
//        this.page = page;
//    }

    public static void sortByRating() {
        page.click(sortByRatingButton);
    }

    public static void sortByDeliveryTime() {
        page.click(sortByDeliveryTimeButton);
    }

    public static void filterByPriceRange(String priceRange) {
        page.click(priceRangeFilter);
        page.click("text=" + priceRange);
    }

    public static void filterByRestaurantType(String restaurantType) {
        page.click(restaurantTypeFilter);
        page.click("text=" + restaurantType);
    }

    public static boolean isRestaurantInResults(String name) {
        return page.isVisible("text=" + name);
    }

    public boolean areRestaurantsOfCuisineInResults(String cuisine) {
        return page.isVisible("text=" + cuisine);
    }

    public boolean areRestaurantsOfMultipleCuisinesInResults(String cuisine1, String cuisine2) {
        return page.isVisible("text=" + cuisine1) || page.isVisible("text=" + cuisine2);
    }

    public boolean areRestaurantsInLocationInResults(String location) {
        return page.isVisible("text=" + location);
    }

    public boolean areRestaurantsSortedByRating() {
        // Implement logic to check if restaurants are sorted by rating
        return true;
    }

    public boolean areRestaurantsSortedByDeliveryTime() {
        // Implement logic to check if restaurants are sorted by delivery time
        return true;
    }

    public boolean areRestaurantsInPriceRange(String priceRange) {
        // Implement logic to check if restaurants are within the selected price range
        return true;
    }

    public boolean areRestaurantsOfTypeInResults(String restaurantType) {
        // Implement logic to check if restaurants of the selected type are in the results
        return true;
    }

    public boolean isNoResultsMessageDisplayed() {
        return page.isVisible(noResultsMessage);
    }

    public boolean arePopularRestaurantsInResults() {
        // Implement logic to check if popular restaurants are in the results
        return true;
    }
}
