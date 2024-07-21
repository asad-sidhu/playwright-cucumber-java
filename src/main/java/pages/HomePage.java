package pages;

import Misc.Methods;
import base.BasePage;

public class HomePage extends BasePage {
	Methods methods = new Methods(page);

	public void clickShop() {
		methods.click("shopLink");
	}

}
