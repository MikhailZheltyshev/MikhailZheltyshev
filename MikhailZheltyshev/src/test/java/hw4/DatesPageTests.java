package hw4;

import base.SelenideTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.DatesPageSelenide;
import pageObjects.HomePageSelenide;

import static com.codeborne.selenide.Selenide.page;
import static enums.Urls.HOME_PAGE;
import static enums.Users.PITER_CHAILOVSKII;

public class DatesPageTests extends SelenideTestBase {

    private HomePageSelenide homePage;
    private DatesPageSelenide datesPageSelenide;

    @BeforeClass
    public void beforeClass() {
        homePage = page(HomePageSelenide.class);
        datesPageSelenide = page(DatesPageSelenide.class);
    }

    @Test
    public void servicePageInterfaceCheck() {

        //1 Open test site by URL
        homePage.open(HOME_PAGE.url);

        //2 Assert Browser title
        homePage.checkTitle();

        //3 Perform login
        homePage.login(PITER_CHAILOVSKII.login, PITER_CHAILOVSKII.password);

        //4 Assert User name in the left-top side of screen that user is loggined
        homePage.checkLoggedUserName(PITER_CHAILOVSKII.displayName);

        //5 Open through the header menu Service -> Dates Page
        homePage.openDatesPageThroughTheHeaderMenu();

        //6 Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most rigth position
        datesPageSelenide.setSlidersFrom0To100();

    }
}
