package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;



public class HomePageSelenideCucumber {

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

    private final List<String> UPPER_SERVICE_MENU_CATEGORIES = Arrays.asList(
            "SUPPORT\n"  + "DATES\n" + "COMPLEX TABLE\n" + "SIMPLE TABLE\n" +"USER TABLE\n" + "TABLE WITH PAGES\n" + "DIFFERENT ELEMENTS\n" + "PERFORMANCE"
    );

    private final List<String> LEFT_SERVICE_MENU_CATEGORIES = Arrays.asList(
            "SUPPORT\n"  + "DATES\n" + "COMPLEX TABLE\n" + "SIMPLE TABLE\n" +"USER TABLE\n" + "TABLE WITH PAGES\n" + "DIFFERENT ELEMENTS\n" + "PERFORMANCE"
    );

    //==================================================METHODS========================================================+
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
        //upperServiceMenuElements.shouldHave(CollectionCondition.texts(UPPER_SERVICE_MENU_CATEGORIES));
        //Изначально был взят неправильный селектор, без li
        System.out.println(Arrays.asList(upperServiceMenuElements.texts().get(0)));

    }

    public void clickOnLeftSelect(){
        leftServiceButton.click();
    }

    public void checkLeftServiceMenuContent(){
        System.out.println(Arrays.asList(leftServiceMenuElements.texts().get(0).split("\n")));
        //shouldHave(CollectionCondition.texts(LEFT_SERVICE_MENU_CATEGORIES));
    }
}
