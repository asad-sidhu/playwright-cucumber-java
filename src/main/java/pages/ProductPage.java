
package pages;

import Misc.Methods;
import base.BasePage;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProductPage extends BasePage {
    public static Methods methods = new Methods();
    public static String expectedResult;


    // Locators
    private String addToCartButton = "//button//span[text()='Add to cart']";
    private String sortByDropdown = "//select[@id='SortBy']";
    private String filterButton = "//a[@href='#SideFilters']";
    private String productTitle = "ul#product-grid a.product-card-title";
    private String productSale = "ul#product-grid li span.badge.onsale";
    private String productPiece = "ul#product-grid li span.pcstyle";
    private String productPrice = "ul#product-grid span.price.on-sale";





    // Methods
    public void addToCart() {
        page.click(addToCartButton);
        methods.waitFor(5);
    }

    public void openFilterPopup() {
        page.click(filterButton);
        methods.waitFor(1);
    }

    public String filterProducts(String filter) {
        if (!filter.equalsIgnoreCase("")) {
        page.click("//summary[text() = '"+filter+"']");
        expectedResult = page.textContent("//summary[text() = '"+filter+"']/following-sibling::*[2]//li[1]").replace(" ","");
        methods.waitFor(4);
        page.click("//summary[text() = '"+filter+"']/following-sibling::*[2]//li[1]");
        methods.waitFor(4);
        }
        return expectedResult;
    }

    public String getFilteredProducts(String filter ) {
        String actualresult = null;
        switch (filter){
            case "Discount":
                actualresult = page.locator(productSale).first().textContent().split("Save ")[1];
                break;
            case "Piece":
                actualresult = page.locator(productPiece).first().textContent().replace(" ","")+"S";
                break;
            case "Size":
                if (page.locator("//ul[@id='product-grid']//li//div[contains(@class, 'product-card-sizes--size')]//span[text()= '"+expectedResult+"']").count()>1) {
                    actualresult = "Pass";
                }else {
                    actualresult = "Fail";
                }
                break;
            default:
                break;
        }

        return actualresult;
    }

    public void applySorting(String order) {
        switch (order){
            case "A-Z":
                page.locator(sortByDropdown).selectOption("Alphabetically, A-Z");
                break;
            case "Z-A":
                page.locator(sortByDropdown).selectOption("Alphabetically, Z-A");
                break;
            case "Price lower to higher":
                page.locator(sortByDropdown).selectOption("Price, low to high");
                break;
            case "Price higher to lower":
                page.locator(sortByDropdown).selectOption("Price, high to low");
                break;
            default:
                System.out.println("Invalid Option");
                break;
        }
        methods.waitFor(4);
    }

    public void verifyAlphabeticalSorting(String order) {

        List<String> productNames = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            productNames.add(page.locator(productTitle).nth(i).textContent());
        }
        System.out.println("Actual Sorting: "+productNames);

        List<String> sortedProductNames = new ArrayList<>(productNames);

        switch (order){
            case "A-Z":
                sortedProductNames = sortedProductNames.stream().sorted().collect(Collectors.toList());
                break;
            case "Z-A":
                sortedProductNames = sortedProductNames.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
                break;
            case "Price lower to higher":
                page.locator(sortByDropdown).selectOption("Price, low to high");
                break;
            case "Price higher to lower":
                page.locator(sortByDropdown).selectOption("Price, high to low");
                break;
            default:
                System.out.println("Invalid Option");
                break;
        }
        System.out.println("Expected Sorting: "+sortedProductNames);
        Assert.assertEquals(productNames, sortedProductNames, "Products are not sorted in " + order + " order");
        methods.waitFor(4);
    }

    public void verifyPriceSorting(String order) {

        List<Integer> productPrices = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            productPrices.add(Integer.parseInt(page.locator(productPrice).nth(i).textContent().split("PKR ")[1].replace(",","").trim()));
        }
        System.out.println("Actual Sorting: "+productPrices);

        List<Integer> sortedPrices = new ArrayList<>(productPrices);

        switch (order){
            case "Price lower to higher":
                Collections.sort(sortedPrices);
                break;
            case "Price higher to lower":
                Collections.sort(sortedPrices, Collections.reverseOrder());
                break;
            default:
                System.out.println("Invalid Option");
                break;
        }
        System.out.println("Expected Sorting: "+sortedPrices);
        Assert.assertEquals(productPrices, sortedPrices, "Products are not sorted in " + order + " order");
        methods.waitFor(4);
    }


}
