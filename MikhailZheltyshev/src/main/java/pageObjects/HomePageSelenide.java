package pageObjects;

import com.codeborne.selenide.*;
import enums.Urls;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.ServiceMenuButtons.DIFFERENT_ELEMENTS;
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

    @FindBy(css = "[class = 'sub']")
    private ElementsCollection leftServiceMenuElements;

    private final String EXPECTED_HOME_PAGE_TITLE = "Home Page";

    private final List<String> EXPECTED_UPPER_SERVICE_MENU_CATEGORIES = Arrays.asList(
            "SUPPORT","DATES","COMPLEX TABLE","SIMPLE TABLE", "TABLE WITH WAGES","DIFFERENT ELEMENTS"
    );

    private final List<String> EXPECTED_LEFT_SERVICE_MENU_CATEGORIES = Arrays.asList(
            "SUPPORT","DATES","COMPLEX TABLE","SIMPLE TABLE", "TABLE WITH WAGES","DIFFERENT ELEMENTS"
    );

    //==================================================METHODS=========================================================
    public void open(String url){
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

    public void clickOnUpperSelect(){
        upperServiceButton.click();
    }

    public void checkUpperServiceMenuContent(){
        //upperServiceMenuElements.shouldHave(CollectionCondition.exactTexts(EXPECTED_UPPER_SERVICE_MENU_CATEGORIES));
        //assertTrue(EXPECTED_UPPER_SERVICE_MENU_CATEGORIES.containsAll(upperServiceMenuElements.texts()));
    }

    public void clickOnLeftSelect(){
        leftServiceButton.click();
    }

    public void checkLeftServiceMenuContent(){
        //leftServiceMenuElements.shouldHave(CollectionCondition.exactTexts(EXPECTED_LEFT_SERVICE_MENU_CATEGORIES));
        //assertTrue(EXPECTED_LEFT_SERVICE_MENU_CATEGORIES.containsAll(leftServiceMenuElements.texts()));
    }

    public void openDifferentElementsPageThroughTheHeaderMenu() {
        clickOnUpperSelect();
        upperServiceMenuElements.find(Condition.text(DIFFERENT_ELEMENTS.name)).click();
        assertEquals(WebDriverRunner.url(), DIFFERENT_ELEMENTS_PAGE.url);
    }
}
