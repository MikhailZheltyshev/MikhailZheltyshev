package pageObjects;

import com.codeborne.selenide.*;
import enums.Users;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.ServiceMenuButtons.DATES;
import static enums.ServiceMenuButtons.DIFFERENT_ELEMENTS;
import static enums.ServiceMenuCategories.getExpectedCategoriesList;
import static enums.Urls.*;
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

    //==================================================METHODS=========================================================
    @Step("Open test site by URL")
    public void open() {
        Selenide.open(HOME_PAGE.url);
    }

    @Step("Assert Browser title")
    public void checkTitle() {
        assertEquals(getWebDriver().getTitle(), EXPECTED_HOME_PAGE_TITLE);
    }

    @Step("Perform login")
    public void login(Users user) {
        profileButton.click();
        login.sendKeys(user.login);
        password.sendKeys(user.password);
        submit.click();
    }

    @Step("Assert User name in the left-top side of screen that user is logged")
    public void checkLoggedUserName(Users user) {
        loggedUserNameElement.shouldBe(visible);
        loggedUserNameElement.shouldHave(text(user.displayName));
    }

    @Step("Click on \"Service\" subcategory in the header")
    public void clickOnUpperSelect() {
        upperServiceButton.click();
    }

    @Step("Check that upper \"Service\" drop down contains correct options")
    public void checkUpperServiceMenuContent() {
        clickOnUpperSelect();
        for (String category : getExpectedCategoriesList()) {
            assertTrue(upperServiceMenuElements.texts().contains(category.toUpperCase()));
        }
    }

    @Step("Check that left \"Service\" drop down contains correct options")
    public void checkLeftServiceMenuContent() {
        leftServiceButton.click();
        for (String category : getExpectedCategoriesList()) {
            assertTrue(leftServiceMenuElements.texts().contains(category));
        }
    }

    @Step("Open through the header menu Service -> Different Elements Page")
    public void openDifferentElementsPageThroughTheHeaderMenu() {
        clickOnUpperSelect();
        upperServiceMenuElements.find(Condition.text(DIFFERENT_ELEMENTS.name)).click();
        assertEquals(WebDriverRunner.url(), DIFFERENT_ELEMENTS_PAGE.url);
    }

    @Step("Open through the header menu Service -> Dates Page")
    public void openDatesPageThroughTheHeaderMenu() {
        clickOnUpperSelect();
        upperServiceMenuElements.find(Condition.text(DATES.name)).click();
        assertEquals(WebDriverRunner.url(), DATES_PAGE.url);
    }
}
