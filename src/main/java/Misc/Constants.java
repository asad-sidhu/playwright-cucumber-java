package Misc;

import utils.PlaywrightDriver;

public class Constants {
    // URLs
    public static final String BASE_URL = PlaywrightDriver.config.getProperty("url");
    public static final String HOME_URL = PlaywrightDriver.config.getProperty("url")+"/";
    public static final String LOGIN_URL = PlaywrightDriver.config.getProperty("url")+"/account/login";
    public static final String SIGNUP_URL = PlaywrightDriver.config.getProperty("url")+"/account/register";
    public static final String CART_URL = PlaywrightDriver.config.getProperty("url")+"/cart";
    public static final String SALE_URL = PlaywrightDriver.config.getProperty("url")+"/collections/sale";

    // Credentials
    public static final String USERNAME = "testuser";
    public static final String PASSWORD = "password123";

    // RestaurantSearchPageouts
    public static final int IMPLICIT_WAIT = 10; // in seconds
}