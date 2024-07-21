package step_defs;


import Misc.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.PlaywrightDriver;

public class RestaurantSearchSteps {

    @Given("The user is on the Uber Eats homepage")
    public void the_user_is_on_the_uber_eats_homepage() {
        PlaywrightDriver.openPage(Constants.HOME_URL);
        System.out.println("hey");
    }
    @When("The user enters the name of the restaurant in the search bar")
    public void the_user_enters_the_name_of_the_restaurant_in_the_search_bar() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("The user clicks the search button")
    public void the_user_clicks_the_search_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("The restaurant should appear in the search results")
    public void the_restaurant_should_appear_in_the_search_results() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
