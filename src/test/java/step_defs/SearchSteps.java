package step_defs;

import Misc.Constants;
import Misc.Methods;
import com.microsoft.playwright.Page;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.HomePage;
import pages.SearchPage;
import utils.PlaywrightDriver;

import java.nio.file.Paths;

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

    @When("I search for {string}")
    public void i_search_for(String query) throws InterruptedException {
        searchPage.performSearch(query);
    }

    @Then("I should see results related to {string}")
    public void i_should_see_results_related_to(String query) {
        Assert.assertTrue(searchPage.areResultsDisplayed(), "Results should be displayed for: " + query);
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
}
