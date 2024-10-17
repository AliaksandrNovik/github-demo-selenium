package pages.auth;

import static com.codeborne.selenide.Selenide.$;

import io.qameta.allure.Step;
import pages.HomePage;

public class LogoutPage {

    @Step
    public HomePage clickSignOutFromAllAccountsBtn() {
        $("form.inline-form.width-full input[type='submit']").click();
        return new HomePage();
    }

}
