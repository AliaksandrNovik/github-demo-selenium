package config;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class BrowserConfig {

    public static void selectBrowser(String browser) {
        if (browser.equals("chrome")) {
            Configuration.browser = "Chrome";
            ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
        } else if (browser.equals("firefox")) {
            Configuration.browser = "Firefox";
            ChromeDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
        } else {
            throw new IllegalStateException("Browser " + browser + " not supported in tests");
        }
    }
}
