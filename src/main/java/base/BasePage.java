package base;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;
import org.testng.Assert;
import utils.PlaywrightDriver;

public class BasePage {
    public static Page page;
    private String cartItemCount = ".thb-item-count";
    public BasePage() {
        page = PlaywrightDriver.getPage();

    }
    public String getCartItemCount() {
        return  page.locator(cartItemCount).textContent();
    }


}
