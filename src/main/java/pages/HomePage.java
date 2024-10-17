package pages;


import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import pages.auth.LoginPage;

public class HomePage {

    @Step
    public LoginPage navigateToLogin(){
        Selenide.open("login");
        return new LoginPage();
    }

    @Step
    public void verifyMainPageUrl(){
        webdriver().shouldHave(url(Configuration.baseUrl));
    }

}
