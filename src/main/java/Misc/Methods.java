package Misc;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import com.microsoft.playwright.options.SelectOption;
import io.qameta.allure.Allure;
import org.testng.Assert;
import pages.HomePage;
import utils.PlaywrightDriver;

import java.io.ByteArrayInputStream;

public class Methods extends HomePage {



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
	public void pressKey(String key) {
		try {
			page.keyboard().press(key);
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

	// Method to capture and attach screenshots
	public void attachScreenshot(String description) {
		byte[] screenshot = page.screenshot();
		Allure.addAttachment(description, "image/png", new ByteArrayInputStream(screenshot), "png");
	}
}
