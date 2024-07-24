
package pages;

import Misc.Constants;
import Misc.Methods;
import base.BasePage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginPage extends BasePage {
    public static Methods methods = new Methods();


    // Locators
    private String signUpLink = "//a[text() = 'Create an account']";
    private String forgotPasswordLink = "//a[text() = 'Forgot your password?']";
    private String loginButton = "div#login button";
    private String firstNameField = "//input[@placeholder = 'First name']";
    private String lastNameField = "//input[@placeholder = 'Last name']";
    private String signupEmailField = "//form[@action = '/account']//input[@placeholder = 'Email address']";
    private String signupPasswordField = "//form[@action = '/account']//input[@placeholder = 'Password']";
    private String loginEmailField = "//form[@action = '/account/login']//input[@placeholder = 'Email address']";
    private String loginPasswordField = "//form[@action = '/account/login']//input[@placeholder = 'Password']";
    private String recoverEmailField = "//form[@action = '/account/recover']//input[@placeholder = 'Email address']";
    private String registerButton = "form#create_customer button span";
    private String logoutLink = "a[title='Log out']";



    // Methods
    public void fillRegistrationForm(String firstName, String lastName, String email, String password) {
        page.locator(firstNameField).fill(firstName);
        methods.waitFor(1);
        page.locator(lastNameField).fill(lastName);
        methods.waitFor(1);
        page.locator(signupEmailField).fill(email);
        methods.waitFor(1);
        page.locator(signupPasswordField).fill(password);
        methods.waitFor(1);
    }

    public void submitRegistrationForm() {
        methods.waitFor(5);
        methods.pressKey("Enter");
        methods.waitFor(5);
    }

    public boolean isLoginSuccessful() {
        return page.locator("//a[@title = 'My Account']/span[text() = 'My Account']").isVisible();
    }

    public void logout() {
         page.locator("//a[@title = 'My Account']/span[text() = 'My Account']").click();
         page.locator(logoutLink).click();

    }
    public void login(String email, String password) {
        page.locator(loginEmailField).fill(email);
        page.locator(loginPasswordField).fill(password);
        methods.waitFor(2);
        methods.pressKey("Enter");
        methods.waitFor(5);

    }
}
