package pages.auth;

import static com.codeborne.selenide.Selenide.$;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.annotations.Optional;
import pages.MyAccountPage;

public class LoginPage  {

    @Step
    public LoginPage enterExistingEmail(@Optional String userEmail) {
        $(By.id("login_field")).setValue(userEmail);
        return this;
    }

    @Step
    public LoginPage enterPassword(@Optional String password) {
        $(By.id("password")).setValue(password);
        return this;
    }

    @Step
    public MyAccountPage clickSignInBtn() {
        $("input[name='commit']").click();
        return new MyAccountPage();
    }

}
