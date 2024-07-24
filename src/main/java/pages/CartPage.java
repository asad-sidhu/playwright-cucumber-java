
package pages;

import Misc.Constants;
import Misc.Methods;
import base.BasePage;
import utils.PlaywrightDriver;

public class CartPage extends BasePage {
    public static Methods methods = new Methods();


    // Locators
    private String deleteProductButton = "a.remove.cart-remove-desktop";
    private String emptyCartMessage = "//h1[text() = 'Your cart is empty']";
    private String quantityInput = "td.product-quantity input.qty";
    private String checkOutButton = "button.checkout-button.button.full";
    private String productPrice = ".product-subtotal span.price";
    private String totalPrice = "button.checkout-button.button.full span";




    // Methods
    public boolean isProductInCart(String productName) {
        if (!page.title().equalsIgnoreCase(Constants.CART_URL)) {
            navigateToCartPage();
        }
        System.out.println(productName);
        return page.locator("//td[@class='product-name']//img[@src = '"+productName+"']").isVisible();
    }

    public void navigateToCartPage() {
        PlaywrightDriver.openPage(Constants.CART_URL);
    }

    public void removeProductFromCart() {
        page.click(deleteProductButton);
        methods.waitFor(3);
    }

    public boolean isCartEmpty() {
        return page.locator(emptyCartMessage).isVisible();
    }

    public void updateProductQuantity(int quantity) {
        page.fill(quantityInput, String.valueOf(quantity));
        methods.pressKey("Enter");
        methods.waitFor(3);
    }

    public String getProductQuantity() {
        return page.locator(quantityInput).getAttribute("value");
    }

    public String getTotalPrice() {
        return page.locator(totalPrice).textContent().split("PKR ")[1].replace(",","");
    }

    public boolean areProductDetailsVisible() {
        return page.locator("css=selector-for-product-details").isVisible();
    }

    public String getProductPrice() {
        return page.locator(productPrice).textContent().split("PKR ")[1].replace(",","");
    }
}
