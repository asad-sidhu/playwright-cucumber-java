package step_defs;

import Misc.Constants;
import Misc.Methods;
import com.microsoft.playwright.Page;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import org.testng.Assert;
import pages.LoginPage;
import pages.ProductPage;
import utils.PlaywrightDriver;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductsSteps {

    private final Page page = PlaywrightDriver.getPage();
    private final LoginPage loginPage = new LoginPage();
    private final ProductPage productPage = new ProductPage();
    public static Methods methods = new Methods();


    @Given("I am on the Edenrobe products page")
    public void i_am_on_the_edenrobe_products_page() {
        try {
            PlaywrightDriver.openPage(Constants.SALE_URL); // Replace with the actual products page URL
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("I sort the products by {string}")
    public void i_sort_the_products_by(String order) {
        try {
            productPage.applySorting(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When ("I open the filter popup")
    public void i_open_filter_popup() {
        try {
            productPage.openFilterPopup();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When ("I filter the products")
    public void i_filter_the_products(DataTable table) {
        try {
            List<Map<String,String>> data = table.asMaps(String.class, String.class);
            for (Map<String,String> row: data) {
                productPage.filterProducts(row.get("filter"));
                System.out.println(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("I should see products sorted in {string} order")
    public void i_should_see_products_sorted_in_order(String order) {
        try {
            switch (order){
                case "A-Z":
                case "Z-A":
                    productPage.verifyAlphabeticalSorting(order);
                    break;
                case "Price lower to higher":
                case "Price higher to lower":
                    productPage.verifyPriceSorting(order);
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } catch (AssertionError e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("I should see products according to the filter applied")
    public void i_should_see_filtered_products(DataTable table) {
        try {
            List<Map<String,String>> data = table.asMaps(String.class,String.class);
            for (Map<String,String> row: data) {
                productPage.getFilteredProducts(row.get("filter"));
                String expectedResult = productPage.filterProducts("").trim();
                String actualResult = productPage.getFilteredProducts(row.get("filter")).trim();
                System.out.println(expectedResult);
                System.out.println(actualResult);
                Assert.assertTrue(actualResult.contains(expectedResult), "Test Case Failed");
            }
        } catch (AssertionError e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}