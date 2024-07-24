package step_defs;

import Misc.Constants;
import Misc.Methods;
import base.BasePage;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductPage;
import pages.SearchPage;
import utils.PlaywrightDriver;

public class AddToCartSteps {

    private final Page page = PlaywrightDriver.getPage();
    private final CartPage cartPage = new CartPage();
    private final SearchPage searchPage = new SearchPage();
    private final BasePage basePage = new BasePage();
    private final ProductPage productPage = new ProductPage();
    public static Methods methods = new Methods();
    public static String productName;
    public static String productPrice;



    @When("I select a product from the search results")
    public void i_select_a_product_from_the_search_results() {
        try {
            productName = searchPage.selectFirstProduct();
        } catch (Exception e) {
            methods.attachScreenshot("");
            e.printStackTrace();
            throw e;
        }
    }

    @When("I add the product to the cart")
    public void i_add_the_product_to_the_cart() {
        try {
            productPage.addToCart();
        } catch (Exception e) {
            methods.attachScreenshot("");
            e.printStackTrace();
            throw e;
        }
    }

    @Then("I should see the product in the cart")
    public void i_should_see_the_product_in_the_cart() {
        try {
            boolean productInCart = cartPage.isProductInCart(productName);
            Assert.assertTrue(productInCart, "Product should be in the cart");
        } catch (AssertionError e) {
            e.printStackTrace();
            methods.attachScreenshot("");
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            methods.attachScreenshot("");
            throw e;
        }
    }

    @Given("I have a product in my cart")
    public void i_have_a_product_in_my_cart() throws InterruptedException {
        cartPage.navigateToCartPage();
        if (basePage.getCartItemCount().equalsIgnoreCase("0")) {
            searchPage.navigateToHomePage();
            searchPage.performSearch("shirt");
            i_select_a_product_from_the_search_results();
            i_add_the_product_to_the_cart();
            i_should_see_the_product_in_the_cart();
        }
    }

    @When("I remove the product from the cart")
    public void i_remove_the_product_from_the_cart() {
        try {
            cartPage.removeProductFromCart();
        } catch (Exception e) {
            e.printStackTrace();
            methods.attachScreenshot("");
            throw e;
        }
    }

    @Then("I should see an empty cart message")
    public void i_should_see_an_empty_cart_message() {
        try {
            boolean emptyCartMessage = cartPage.isCartEmpty();
            Assert.assertFalse(emptyCartMessage, "Empty cart message should be displayed");
        } catch (AssertionError e) {
            e.printStackTrace();
            methods.attachScreenshot("");
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            methods.attachScreenshot("");
            throw e;
        }
    }

    @When("I update the quantity of the product to {int}")
    public void i_update_the_quantity_of_the_product_to(Integer quantity) {
        try {
            productPrice = cartPage.getProductPrice();
            cartPage.updateProductQuantity(quantity);
        } catch (Exception e) {
            e.printStackTrace();
            methods.attachScreenshot("");
            throw e;
        }
    }

    @Then("I should see the quantity updated in the cart to {int}")
    public void i_should_see_the_quantity_updated_in_the_cart(int quantity) {
        try {
            String cartQuantity = cartPage.getProductQuantity();
            Assert.assertEquals(cartQuantity, String.valueOf(quantity), "Cart quantity should be updated");
        } catch (AssertionError e) {
            e.printStackTrace();
            methods.attachScreenshot("");
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            methods.attachScreenshot("");
            throw e;
        }
    }

    @Then("I should see the total price updated to * {int}")
    public void i_should_see_the_total_price_updated(int quantity) {
        try {
            int totalPrice = Integer.parseInt(cartPage.getTotalPrice());
            double expectedPrice = Integer.parseInt(productPrice) * quantity;
            Assert.assertEquals(totalPrice, expectedPrice, "Total price should be updated");
        } catch (AssertionError e) {
            e.printStackTrace();
            methods.attachScreenshot("");
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            methods.attachScreenshot("");
            throw e;
        }
    }

    @When("I view the cart")
    public void i_view_the_cart() {
        try {
            cartPage.navigateToCartPage();
        } catch (Exception e) {
            e.printStackTrace();
            methods.attachScreenshot("");
            throw e;
        }
    }

    @Then("I should see the product details in the cart")
    public void i_should_see_the_product_details_in_the_cart() {
        try {
            boolean productDetailsVisible = cartPage.areProductDetailsVisible();
            Assert.assertTrue(productDetailsVisible, "Product details should be visible in the cart");
        } catch (AssertionError e) {
            e.printStackTrace();
            methods.attachScreenshot("");
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            methods.attachScreenshot("");
            throw e;
        }
    }
}

