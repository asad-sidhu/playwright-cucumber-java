package Misc;

import utils.PlaywrightDriver;

public class Constants {
    // URLs
    public static final String BASE_URL = PlaywrightDriver.config.getProperty("url");
    public static final String HOME_URL = PlaywrightDriver.config.getProperty("url")+"/";

    // Credentials
    public static final String USERNAME = "testuser";
    public static final String PASSWORD = "password123";

    // Timeouts
    public static final int IMPLICIT_WAIT = 10; // in seconds
}