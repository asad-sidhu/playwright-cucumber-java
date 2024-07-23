package step_defs;

import Misc.Constants;
import Misc.Methods;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.SearchPage;
import utils.PlaywrightDriver;


public class SearchSteps {
//
    private final Page page = PlaywrightDriver.getPage();
    private final SearchPage searchPage = new SearchPage();
    private final SearchPage restaurantSearchPage = new SearchPage();
    public static Methods methods = new Methods();

    @Given("I am on the Edenrobe homepage")
    public void i_am_on_the_edenrobe_homepage() {
        try {
            PlaywrightDriver.openPage(Constants.HOME_URL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Given("I am on the Edenrobe homepage search section")
    public void i_am_on_the_edenrobe_homepage_search_section() {
        try {
            PlaywrightDriver.openPage(Constants.HOME_URL);
            searchPage.clickSearch();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("I search for {string}")
    public void i_search_for(String query) throws InterruptedException {
        searchPage.performSearch(query);
    }

    @Then("I should see results related to {string}")
    public void i_should_see_results_related_to(String query) {
        Assert.assertTrue(searchPage.areResultsDisplayed(query).get("isVisible"), "Results should be displayed for: " + query);
        Assert.assertTrue(searchPage.areResultsDisplayed(query).get("searchResultsCorrect"), "Correct Results should be displayed for: " + query);
    }

    @Then("I should see a {string} message")
    public void i_should_see_a_message(String message) {
        boolean noResultsMessage = page.locator("text=" + message).isVisible();
        Assert.assertTrue(noResultsMessage, "Message should be displayed: " + message);
    }

    @Then("I should see the homepage with no search results")
    public void i_should_see_the_homepage_with_no_search_results() {
        boolean homepageVisible = page.locator("text='Featured Products'").isVisible();
        Assert.assertTrue(homepageVisible, "Homepage should be displayed with no search results");
    }
    @When("I click the search button")
    public void i_click_the_search_button() {
        searchPage.clickSearch();
    }
    @Then("I should see the popular searches section")
    public void i_should_see_the_popular_searches_section() {
        Assert.assertTrue(searchPage.isPopularSearchesSectionDisplayed(), "Popular Searches Section should be displayed with all popular search options");
    }
    @Then("I should see the trending now section")
    public void i_should_see_the_trending_now_section() {
        Assert.assertTrue(searchPage.istrendingNowSectionDisplayed(), "Trending Now Section should be displayed with all popular search options");
    }
    @Then("The user should be shown results according to the popular search option that user clicks")
    public void i_click_a_popular_search_option() {
        String optionText = searchPage.getPopularSearchOption();
            searchPage.clickPopularSearchOption();
            Assert.assertEquals(searchPage.verifyPopularSearchResult().toLowerCase(),optionText.toLowerCase(),"Popular Search Results do not Match");
        }
    @Then("The user should be shown results according to the trending now option that user clicks")
    public void i_click_a_trending_now_option() {
        String optionText = searchPage.getTrendingNowOption();
            searchPage.clickTrendingNowOption();
            Assert.assertEquals(searchPage.verifyTrendingNowResult().toLowerCase(),optionText.toLowerCase(),"Trending Now Results do not Match");
        }
}
