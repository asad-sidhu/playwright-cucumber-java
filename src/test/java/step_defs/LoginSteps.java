package step_defs;

import Misc.Constants;
import Misc.Methods;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;
import utils.PlaywrightDriver;

public class LoginSteps {

    private final Page page = PlaywrightDriver.getPage();
    private final LoginPage loginPage = new LoginPage();
    public static Methods methods = new Methods();


    @Given("I am on the Edenrobe registration page")
    public void i_am_on_the_edenrobe_registration_page() {
        try {
            PlaywrightDriver.openPage(Constants.SIGNUP_URL);
        } catch (Exception e) {
            e.printStackTrace();
            methods.attachScreenshot("Error on registration page");
            throw e;
        }
    }

    @Given("I am on the Edenrobe login page")
    public void i_am_on_the_edenrobe_login_page() {
        try {
            PlaywrightDriver.openPage(Constants.LOGIN_URL);
        } catch (Exception e) {
            e.printStackTrace();
            methods.attachScreenshot("Error on registration page");
            throw e;
        }
    }

    @When("I fill out the registration form with valid details")
    public void i_fill_out_the_registration_form_with_valid_details() {
        try {
            loginPage.fillRegistrationForm("John", "Doe", "asadsidhu.doe@yahoo.com", "Sidh233425");
        } catch (Exception e) {
            e.printStackTrace();
            methods.attachScreenshot("Error while filling registration form");
            throw e;
        }
    }

    @And("I submit the registration form")
    public void i_submit_the_registration_form() {
        try {
            loginPage.submitRegistrationForm();
        } catch (Exception e) {
            e.printStackTrace();
            methods.attachScreenshot("Error while submitting registration form");
            throw e;
        }
    }

    @Then("I should see a successful registration message")
    public void i_should_see_a_successful_registration_message() {
        try {
            Assert.assertTrue(loginPage.isLoginSuccessful(), "Registration should be successful");
        } catch (AssertionError e) {
            e.printStackTrace();
            methods.attachScreenshot("Registration was not successful");
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            methods.attachScreenshot("Error while verifying registration success");
            throw e;
        }
    }

    @When("I log in with the valid credentials")
    public void i_log_in_with_the_valid_credentials() {
        try {
            loginPage.login("a2260223667@gmail.com", "Sidh233425");
        } catch (Exception e) {
            e.printStackTrace();
            methods.attachScreenshot("Error while logging in");
            throw e;
        }
    }

    @Then("I should see the user dashboard")
    public void i_should_see_the_user_dashboard() {
        try {
            Assert.assertTrue(loginPage.isLoginSuccessful(), "User dashboard should be visible");
        } catch (AssertionError e) {
            e.printStackTrace();
            methods.attachScreenshot("User dashboard not visible");
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            methods.attachScreenshot("Error while verifying user dashboard");
            throw e;

        }
    }
}