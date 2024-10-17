package io.mend;

import base.BaseSuite;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MyAccountPage;

public class RepositoriesSuite extends BaseSuite {

    @BeforeMethod
    @Parameters({"username", "password"})
    public void login(String userName, String password) {
        new HomePage()
                .navigateToLogin()
                .enterExistingEmail(userName)
                .enterPassword(password)
                .clickSignInBtn();
    }

    @Test
    @Story("Checking existing repo search functionality")
    public void searchExistingRepos() {
        new MyAccountPage()
                .searchRepository("java")
                .verifyRepositoriesSectionAppeared();
    }

    @Test
    @Story("Check opening of existing repository")
    public void openSearchedExistingRepo() {
        new MyAccountPage()
                .searchRepository("java testng")
                .openRepoByName("testng-team/testng")
                .verificationRepoIsOpened();
    }
}
