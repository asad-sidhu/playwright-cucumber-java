package pages;

import Misc.Constants;
import Misc.Methods;
import base.BasePage;
import com.microsoft.playwright.Page;

public class HomePage extends BasePage {


	// Locators
	private static final String locationSearchBar = "input#location-typeahead-home-input";
	private static final String locationListItem = "li#location-typeahead-home-item-0 .il";
	private static final String deliveryAddressLabel = "//*[@data-testid = 'delivery-address-label']";
	private static final String searchBar = "input[placeholder='Search Uber Eats']";
	private static final String searchButton = "button[type='submit']";
	private static final String cuisineFilter = "button[data-testid='cuisine-filter']";
	private static final String locationFilter = "input[data-testid='location-search']";
	private static final String popularRestaurantsLink = "a[href='/popular']";
	static Methods methods = new Methods();
//	public HomePage(Page page) {
//		this.page = HomePage.page;
//	}

	public void navigate() {
		page.navigate(Constants.HOME_URL);
	}

	public static void searchLocationByName(String name) {
		page.fill(locationSearchBar, name);
	}

	public static String isPredictiveSearchFunctional() {
		return page.textContent(locationListItem);
	}

	public static void selectLocation() {
		methods.pressKey("ArrowDown");
		methods.pressKey("Enter");
	}

	public static String getDeliveryAddressLabel() {
		return page.textContent(deliveryAddressLabel);
	}

	public static void searchRestaurantByName(String name) {
		page.fill(searchBar, name);
		methods.pressKey("Enter");
	}

	public static void searchRestaurantByCuisineType(String cuisine) {
		page.click(cuisineFilter);
		page.click("text=" + cuisine);
		page.click(searchButton);
	}

	public static void searchRestaurantByMultipleCuisineTypes(String cuisine1, String cuisine2) {
		page.click(cuisineFilter);
		page.click("text=" + cuisine1);
		page.click("text=" + cuisine2);
		page.click(searchButton);
	}

	public static void searchRestaurantByLocation(String location) {
		page.fill(locationFilter, location);
		page.click(searchButton);
	}

	public static void searchPopularRestaurants() {
		page.click(popularRestaurantsLink);
	}
}
