package step_defs;

import com.microsoft.playwright.Page;
import io.cucumber.java.*;
import utils.PlaywrightDriver;

import java.nio.file.Paths;


public class Hooks {
    public static Page page;

    @BeforeAll
    public static void setUp(){
        PlaywrightDriver.setupDriver();
        PlaywrightDriver.fullScreen();
    }

    @AfterAll
    public static void tearDown() {
//        if(scenario.isFailed()) {
            page = PlaywrightDriver.getPage();
            byte[] screenshot = page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./screenshot/screenshot.png")));
//            scenario.attach(screenshot, "image/png", "screenshot");
//        }

        PlaywrightDriver.closeBrowser();
        PlaywrightDriver.quitPlaywright();
    }
}
