
package pages;

import Misc.Constants;
import Misc.Methods;
import base.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.cucumber.java.it.Ma;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchPage extends BasePage {
    public static Methods methods = new Methods();


    // Locators
    private String searchInput = "input[name='q']";
    private String searchButton = "a[title='Search']";
    private String searchResultsGrid = "ul#product-grid";
    private String searchResultsGridTitle = ".collection-banner--title";
    private String popularSearchItems = ".thb-predictive-search--popular a";
    private String productTitle = "h1[class*='product-title']";
    private String trendingNowItems = "div[class=thb-predictive-search--promotion] a[class=product-card-title]";
    private String firstSearchResult = "ul#product-grid li:nth-child(1) a.product-card-title";
    private String firstSearchResultImage = "ul#product-grid li:nth-child(1) img";
    private String noResultsMessage = "text='No results found'";
    private String homepageIndicator = "text='Featured Products'";


    // Methods
    public void navigateToHomePage() {
        page.navigate(Constants.HOME_URL);
    }

    public void clickSearch() {
            page.locator(searchButton).click();
    }

    public void performSearch(String query) throws InterruptedException {
        page.fill(searchInput, query);
        methods.pressKey("Enter");
        Thread.sleep(3000);
    }

    public Map<String,Boolean> areResultsDisplayed(String query) {
        Map<String, Boolean> result = new HashMap<>();
        if (page.locator(searchResultsGrid).isVisible()) {
            result.put("isVisible", page.locator(searchResultsGrid).isVisible());
            result.put("searchResultsCorrect",page.locator(firstSearchResult).textContent().toLowerCase().contains(query.toLowerCase()));
            System.out.println("Actual String : "+page.locator(firstSearchResult).textContent());
            System.out.println("Expected String : "+query.toLowerCase());
        }
        return result;
    }

    public boolean isPopularSearchesSectionDisplayed() {
        return page.locator(popularSearchItems).count()>1;
    }

    public boolean istrendingNowSectionDisplayed() {
        return page.locator(trendingNowItems).count()>1;
    }

    public String getPopularSearchOption() {
        String optionText = page.locator(popularSearchItems).first().textContent();
        return optionText;
    }

    public String getTrendingNowOption() {
        String optionText = page.locator(trendingNowItems).first().textContent();
        return optionText;
    }

    public void clickPopularSearchOption() {
        page.locator(popularSearchItems).first().click();
    }

    public String selectFirstProduct() {
        String product = page.locator(firstSearchResultImage).getAttribute("src");
        page.locator(firstSearchResult).click();
        return product;
    }

    public void clickTrendingNowOption() {
        page.locator(trendingNowItems).first().click();
        methods.waitFor(2);
    }

    public String verifyPopularSearchResult() {
        return page.locator(searchResultsGridTitle).textContent();
    }

    public String verifyTrendingNowResult() {
        return page.locator(productTitle).textContent();
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
