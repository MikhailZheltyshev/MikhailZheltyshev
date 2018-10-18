package hw4;

import base.SelenideTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePageSelenide;
import pageObjects.ServicePageSelenide;

import static com.codeborne.selenide.Selenide.*;
import static enums.Titles.*;
import static enums.Urls.*;
import static enums.Users.PITER_CHAILOVSKII;
import static org.testng.Assert.assertEquals;

public class ServicePageTests extends SelenideTestBase {

    private ServicePageSelenide servicePage;
    private HomePageSelenide homePage;

    @BeforeClass
    public void beforeClass() {
        homePage = page(HomePageSelenide.class);
        servicePage = page(ServicePageSelenide.class);
    }

    @Test
    public void simpleTest() {

        //1 Open test site by URL
        homePage.open(MAIN_PAGE.url);

        //2 Assert Browser title
        homePage.checkTitle(HOME_PAGE.title);

        //3 Perform login
        homePage.login(PITER_CHAILOVSKII.login, PITER_CHAILOVSKII.password);

        //4 Assert User name in the left-top side of screen that user is loggined
        homePage.checkLoggedUserName(PITER_CHAILOVSKII.displayName);

        //5 Click on "Service" subcategory in the header and check that drop down contains options

        //5.1 Click
        homePage.clickOnUpperSelect();

        //5.2 Check for content
        homePage.checkUpperServiceMenuContent();

        //6 Click on Service subcategory in the left section and check that drop down contains options

        //6.1 Click
        homePage.clickOnLeftSelect();

        //6.2 Check for content
        homePage.checkLeftServiceMenuContent();

    }
}
