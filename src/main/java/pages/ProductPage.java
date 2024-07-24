
package pages;

import Misc.Methods;
import base.BasePage;

public class ProductPage extends BasePage {
    public static Methods methods = new Methods();


    // Locators
    private String addToCartButton = "//button//span[text()='Add to cart']";




    // Methods
    public void addToCart() {
        page.click(addToCartButton);
        methods.waitFor(5);
    }
}
