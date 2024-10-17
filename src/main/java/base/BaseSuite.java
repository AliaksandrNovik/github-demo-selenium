package base;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import config.TestListenerConfig;
import org.testng.annotations.*;

import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static config.BrowserConfig.selectBrowser;
import static config.ResourceConfig.loadPropertyName;

@Listeners(TestListenerConfig.class)
public class BaseSuite {

    private static String baseUrl;

    @Parameters({"env", "browser"})
    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(@Optional("test") String env, @Optional("chrome") String browser) {
        selectBrowser(browser);
        clearBrowserCache();
        switch (env) {
            case "test":
                baseUrl = loadPropertyName("UI_BASE_URL");
                break;
            case "prod":
                baseUrl = loadPropertyName("PROD_UI_BASE_URL");
                break;
        }
        Configuration.baseUrl = baseUrl;
        Selenide.open(baseUrl);
        getWebDriver().manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    void after() {
        clearBrowserCache();
        closeWebDriver();
    }

}
