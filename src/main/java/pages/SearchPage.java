
package pages;

import Misc.Constants;
import Misc.Methods;
import base.BasePage;
import com.microsoft.playwright.Page;

import java.util.List;

public class SearchPage extends BasePage {
    public static Methods methods = new Methods();


    // Locators
    private String searchInput = "input[name='q']";
    private String searchButton = "a[title='Search']";
    private String searchResultsGrid = "ul#product-grid";
    private String noResultsMessage = "text='No results found'";
    private String homepageIndicator = "text='Featured Products'";


    // Methods
    public void navigateToHomePage() {
        page.navigate(Constants.HOME_URL);
    }

    public void clickSearch() {
        page.click(searchButton);
    }

    public void performSearch(String query) throws InterruptedException {
        page.fill(searchInput, query);
        methods.pressKey("Enter");
        Thread.sleep(3000);
    }

    public boolean areResultsDisplayed() {
        return page.locator(searchResultsGrid).isVisible();
    }

    public boolean isNoResultsMessageDisplayed() {
        return page.locator(noResultsMessage).isVisible();
    }

    public boolean isHomepageDisplayed() {
        return page.locator(homepageIndicator).isVisible();
    }

    public List<String> getSearchResults() {
        return page.locator(searchResultsGrid).allTextContents();
    }
}
