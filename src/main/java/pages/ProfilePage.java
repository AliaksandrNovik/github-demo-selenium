package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.SetValueOptions;
import java.time.LocalDateTime;
import org.openqa.selenium.By;

public class ProfilePage {

    public ProfilePage clickEditProfile() {
        $x("//button[contains(@class,'edit-button')]").click();
        return this;
    }

    public ProfilePage updateBio(String bioValue) {
        final By inputBio = By.cssSelector("textarea#user_profile_bio");
        $(inputBio).clear();
        $(inputBio).setValue(bioValue);
        $("button[data-target='waiting-form.submit']").click();
        return this;
    }

    public ProfilePage verifyBioWasUpdated(String bioValue){
        $x("//div/div[contains(@class,'bio')]/div").should(text(bioValue));
        return this;
    }
}
