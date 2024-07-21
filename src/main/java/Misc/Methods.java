package Misc;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import com.microsoft.playwright.options.SelectOption;
import org.testng.Assert;
import utils.PlaywrightDriver;

public class Methods {

	public Page page;

	public Methods(Page page) {
		this.page = page;
	}

	public String getPageTitle() {
		return page.title();
	}

	public static void waitFor(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void click(String locator) {
		try {
			page.locator(locator).click();
		} catch (Throwable t) {
			Assert.fail(t.getMessage());
		}
	}

	public void mouseHover(String locator) {
		try {
			page.hover(locator);
		} catch (Throwable t) {
			Assert.fail(t.getMessage());
		}
	}

	public boolean isElementPresent(String locator) {
		try {
			page.waitForSelector(locator, new Page.WaitForSelectorOptions().setTimeout(2000));

			return true;
		} catch (Throwable t) {
			return false;
		}
	}

	public void type(String locator, String value) {
		try {
			page.locator(locator).fill(value);
		} catch (Throwable t) {
			Assert.fail(t.getMessage());
		}
	}

	public void select(String locator, String value) {
		try {
			page.selectOption(locator,new SelectOption().setLabel(value));
		} catch (Throwable t) {
			Assert.fail(t.getMessage());
		}
	}
}
