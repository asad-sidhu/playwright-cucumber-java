package utils;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PlaywrightDriver {
    public static PlaywrightDriver playwrightDriver;
    private Playwright playwright;
    public Browser browser;
    public Page page;
    public static Properties OR = new Properties();
    public static Properties config = new Properties();
    private static FileInputStream fis;
    private static ThreadLocal<Playwright> pw = new ThreadLocal<>();
    private static ThreadLocal<Browser> br = new ThreadLocal<>();
    private static ThreadLocal<Page> pg = new ThreadLocal<>();

    public static Playwright getPlaywright() {
        return pw.get();
    }

    public static Browser getBrowser() {

        return br.get();
    }

    public static Page getPage() {

        return pg.get();
    }


    private PlaywrightDriver() {
        try {
            fis = new FileInputStream("./src/main/resources/properties/config.properties");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            config.load(fis);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        playwright = Playwright.create();
        pw.set(playwright);

        if(config.getProperty("browser").equals("chrome")) {
            browser = getPlaywright().chromium()
                    .launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));

        }else if(config.getProperty("browser").equals("firefox")) {
            browser = getPlaywright().firefox()
                    .launch(new BrowserType.LaunchOptions().setChannel("firefox").setHeadless(false));
        }

        br.set(browser);
        page = getBrowser().newPage();
        pg.set(page);
    }

    public static void setupDriver() {
        playwrightDriver = new PlaywrightDriver();
    }

    public static void fullScreen() {
        getPage().setViewportSize(1920, 1080);
    }


    public static void openPage(String url) {
        getPage().navigate(url,new Page.NavigateOptions().setTimeout(60000));
    }

    public static void closeBrowser() {
        getBrowser().close();
        getPage().close();
    }

    public static void quitPlaywright() {
        if(getPage()!=null) {
            getPlaywright().close();
        }
    }
}
