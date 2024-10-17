package io.mend;

import base.BaseSuite;
import io.qameta.allure.Story;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;

public class LoginSuite extends BaseSuite {

    @Test
    @Story("Check login of existing account")
    @Parameters({"username", "password"})
    public void logInTest(String userName, String password) {
        new HomePage()
                .navigateToLogin()
                .enterExistingEmail(userName)
                .enterPassword(password)
                .clickSignInBtn()
                .verificationForSuccessLogin();
    }

    @Test
    @Story("Check logout of existing account")
    @Parameters({"username", "password"})
    public void logOutTest(String userName, String password) {
        new HomePage()
                .navigateToLogin()
                .enterExistingEmail(userName)
                .enterPassword(password)
                .clickSignInBtn()
                .clickUserIcon()
                .clickSignOutBtn()
                .clickSignOutFromAllAccountsBtn()
                .verifyMainPageUrl();
    }

}
