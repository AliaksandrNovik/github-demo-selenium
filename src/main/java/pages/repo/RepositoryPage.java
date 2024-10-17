package pages.repo;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

public class RepositoryPage {

    private static final By PULL_REQUEST_TAB = By.cssSelector("a#pull-requests-tab");

    public RepositoryPage verificationRepoIsOpened() {
        $(PULL_REQUEST_TAB).shouldBe(visible);
        return this;
    }
}
