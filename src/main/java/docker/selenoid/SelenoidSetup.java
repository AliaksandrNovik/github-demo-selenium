package docker.selenoid;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.selenide.Selenide;
import com.google.common.collect.ImmutableMap;
import config.BrowserConfig;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static config.ResourceConfig.loadPropertyName;

public class SelenoidSetup {

    private static String baseUrl;

    @Parameters({"env", "browser"})
    @BeforeMethod(alwaysRun = true)
    public void beforeEach(@Optional("test") String env, @Optional("chrome") String browser)
            throws MalformedURLException {
        Configuration.baseUrl = "https://github.com/";
        Configuration.browserCapabilities = capabilities();
        Configuration.browser = "chrome";
        Configuration.remote = "http://localhost:4444/wd/hub";

        BrowserConfig.selectBrowser(browser);
        clearBrowserCache();
        switch (env) {
            case "test":
                baseUrl = loadPropertyName("UI_BASE_URL");
                break;
            case "prod":
                baseUrl = loadPropertyName("PROD_UI_BASE_URL");
                break;
        }
        Selenide.open(baseUrl);
        getWebDriver().manage().window().maximize();
    }

    static String selenoidUrl() {
        return "http://localhost:4444/wd/hub";
    }

    static void resetSelenoidSettings() {
        Configuration.remote = null;
        Configuration.browserCapabilities = new DesiredCapabilities();
    }

    @AfterMethod(alwaysRun = true)
    public void afterEach() {
        closeWebDriver();
        resetSelenoidSettings();
    }

    static DesiredCapabilities capabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setCapability("selenoid:options", ImmutableMap.of(
                "enableVNC", true,
                "enableVideo", false
        ));
        return capabilities;
    }

}
