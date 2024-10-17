package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;
import pages.auth.LogoutPage;
import pages.repo.RepositoryPage;

public class MyAccountPage {

    private static final By APP_HEADER_ICON = By.cssSelector("div.AppHeader-user");

    private static final By APP_HEADER_SEARCH_ROW = By.cssSelector("div.AppHeader-search-whenRegular");

    public MyAccountPage verificationForSuccessLogin() {
        $(APP_HEADER_ICON).shouldBe(visible);
        $(APP_HEADER_SEARCH_ROW).shouldBe(visible);
        return this;
    }

    public MyAccountPage clickUserIcon(){
        $(APP_HEADER_ICON).click();
        return this;
    }

    public LogoutPage clickSignOutBtn(){
        $("span[id=':r10:--label']").click();
        return new LogoutPage();
    }

    public MyAccountPage searchRepository(String searchRequest){
        activateSearchRow();
        $("input#query-builder-test").setValue(searchRequest).pressEnter();
        return this;
    }

    public RepositoryPage openRepoByName(String searchRequest){
        $(By.xpath("//div/a[contains(@href,'" + searchRequest + "')]")).click();
        return new RepositoryPage();
    }

    private MyAccountPage activateSearchRow(){
        $(By.id("qb-input-query")).click();
        return this;
    }

    public MyAccountPage verifyRepositoriesSectionAppeared(){
        $("div[data-testid='results-list']").shouldBe(visible);
        return this;
    }

    public ProfilePage clickMyProfileBtn(){
        $("a[id=':re:']").click();
        return new ProfilePage();
    }

}
