package pageObjects;

import com.codeborne.selenide.*;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.ServiceMenuButtons.DATES;
import static enums.ServiceMenuButtons.DIFFERENT_ELEMENTS;
import static enums.Urls.DATES_PAGE;
import static enums.Urls.DIFFERENT_ELEMENTS_PAGE;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageSelenide {

    //==================================================WEB-ELEMENTS====================================================
    @FindBy(css = ".profile-photo")
    private SelenideElement profileButton;

    @FindBy(css = "[id = 'Name']")
    private SelenideElement login;

    @FindBy(css = "[id = 'Password']")
    private SelenideElement password;

    @FindBy(css = ".login [type = 'submit']")
    private SelenideElement submit;

    @FindBy(css = ".profile-photo span")
    private SelenideElement loggedUserNameElement;

    @FindBy(css = "[class = 'dropdown']")
    private SelenideElement upperServiceButton;

    @FindBy(css = "[class = 'dropdown-menu'] > li")
    private ElementsCollection upperServiceMenuElements;

    @FindBy(css = "[class = 'sidebar-menu'] > [index='3']")
    private SelenideElement leftServiceButton;

    @FindBy(css = "[class = 'sub'] > li")
    private ElementsCollection leftServiceMenuElements;

    private final String EXPECTED_HOME_PAGE_TITLE = "Home Page";

    private final List<String> EXPECTED_UPPER_SERVICE_MENU_CATEGORIES = Arrays.asList(
            "Support", "Dates", "Complex Table", "Simple Table", "Table with pages", "Different elements"
    );

    private final List<String> EXPECTED_LEFT_SERVICE_MENU_CATEGORIES = Arrays.asList(
            "Support", "Dates", "Complex Table", "Simple Table", "Table with pages", "Different elements"
    );

    //==================================================METHODS=========================================================
    public void open(String url) {
        Selenide.open(url);
    }

    public void checkTitle() {
        assertEquals(getWebDriver().getTitle(), EXPECTED_HOME_PAGE_TITLE);
    }

    public void login(String name, String pwd) {
        profileButton.click();
        login.sendKeys(name);
        password.sendKeys(pwd);
        submit.click();
    }

    public void checkLoggedUserName(String expectedName) {
        loggedUserNameElement.shouldBe(visible);
        loggedUserNameElement.shouldHave(text(expectedName));
    }

    public void clickOnUpperSelect() {
        upperServiceButton.click();
    }

    public void checkUpperServiceMenuContent() {
        for (String category : EXPECTED_UPPER_SERVICE_MENU_CATEGORIES) {
            assertTrue(upperServiceMenuElements.texts().contains(category.toUpperCase()));
        }
    }

    public void clickOnLeftSelect() {
        leftServiceButton.click();
    }

    public void checkLeftServiceMenuContent() {
        for (String category : EXPECTED_LEFT_SERVICE_MENU_CATEGORIES) {
            assertTrue(leftServiceMenuElements.texts().contains(category));
        }
    }

    public void openDifferentElementsPageThroughTheHeaderMenu() {
        clickOnUpperSelect();
        upperServiceMenuElements.find(Condition.text(DIFFERENT_ELEMENTS.name)).click();
        assertEquals(WebDriverRunner.url(), DIFFERENT_ELEMENTS_PAGE.url);
    }

    public void openDatesPageThroughTheHeaderMenu() {
        clickOnUpperSelect();
        upperServiceMenuElements.find(Condition.text(DATES.name)).click();
        assertEquals(WebDriverRunner.url(), DATES_PAGE.url);
    }
}
