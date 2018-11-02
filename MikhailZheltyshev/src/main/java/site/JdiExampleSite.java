package site;

import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import com.epam.web.matcher.junit.Assert;
import entities.User;
import enums.Users;
import enums.jdi.Pages;
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

    //=======================================WEB-ELEMENTS AND CONSTANTS=================================================
    public static LoginForm loginForm;
    public static HeaderMenu headerMenu;

    @FindBy(css = ".profile-photo")
    public static Label profilePhoto;

    @Step
    public static void login(Users user) {
        profilePhoto.click();
        loginForm.loginAs(new User(user.login, user.password));
    }

    @Step
    public static void checkLoggedInUserName(Users user) {
        Assert.areEquals(profilePhoto.getText(), user.displayName);
    }

    @Step
    public static void openPageByHeader(Pages page) {
        headerMenu.navigation.clickOn(page.displayName);
    }
}

