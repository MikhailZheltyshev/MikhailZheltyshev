package pageObjects;

import com.codeborne.selenide.*;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
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

    @FindBy(css = "[class = 'dropdown-menu']")
    private ElementsCollection upperServiceMenuElements;

    @FindBy(css = "[class = 'sidebar-menu'] > [index='3']")
    private SelenideElement leftServiceButton;

    @FindBy(css = "[class = 'sub']")
    private ElementsCollection leftServiceMenuElements;

    private final String EXPECTED_HOME_PAGE_TITLE = "Home Page";

    private final List<String> UPPER_SERVICE_MENU_CATEGORIES = Arrays.asList(
            "Support", "Dates", "Complex Table", "Simple Table", "Tables With Wages", "Different Elements"
    );

    private final List<String> LEFT_SERVICE_MENU_CATEGORIES = Arrays.asList(
            "Support", "Dates", "Complex Table", "Simple Table", "Tables With Wages", "Different Elements"
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
        upperServiceMenuElements.shouldHave(CollectionCondition.texts(UPPER_SERVICE_MENU_CATEGORIES));
    }

    public void clickOnLeftSelect(){
        leftServiceButton.click();
    }

    public void checkLeftServiceMenuContent(){
        leftServiceMenuElements.shouldHave(CollectionCondition.texts(LEFT_SERVICE_MENU_CATEGORIES));
    }
}
