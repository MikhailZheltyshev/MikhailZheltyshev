package site;

import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import com.epam.web.matcher.junit.Assert;
import entities.User;
import enums.Users;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import site.pages.HomePageJdi;
import site.pages.MetalAndColorsPageJdi;
import site.sections.HeaderMenu;
import site.sections.LoginForm;

@JSite("https://epam.github.io/JDI/")
public class JdiExampleSite extends WebSite {
    public static HomePageJdi homePage;
    public static MetalAndColorsPageJdi metalAndColorsPage;

    public static LoginForm loginForm;
    public static HeaderMenu headerMenu;

    @FindBy(css = ".profile-photo")
    public static Label profilePhoto;

    @Step
    public static void login() {
        profilePhoto.click();
        loginForm.loginAs(new User());
    }

    @Step
    public static void checkLoggedInUserName(String expectedUserName) {
        Assert.areEquals(profilePhoto.getText(), expectedUserName);
    }

    @Step
    public static void openMetalAndColorsPageByHeader() {
        headerMenu.navigation.clickOn("Metals & Colors");
    }
}
