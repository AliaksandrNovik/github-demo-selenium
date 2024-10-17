package io.mend;

import base.BaseSuite;
import io.qameta.allure.Story;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;

public class ProfileSuite extends BaseSuite {

    @Test
    @Story("Check edit Bio functionality for the Profile Section")
    @Parameters({"username", "password"})
    public void openSearchedExistingRepo(String userName, String password) {
        new HomePage()
                .navigateToLogin()
                .enterExistingEmail(userName)
                .enterPassword(password)
                .clickSignInBtn()
                .clickUserIcon()
                .clickMyProfileBtn()
                .clickEditProfile()
                .updateBio("testBio")
                .verifyBioWasUpdated("testBio");
    }
}
