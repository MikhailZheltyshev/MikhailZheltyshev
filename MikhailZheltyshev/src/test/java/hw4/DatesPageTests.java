package hw4;

import base.SelenideTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.DatesPageSelenide;
import pageObjects.HomePageSelenide;

import static com.codeborne.selenide.Selenide.page;
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
    public void datesPageInterfaceCheck() {

        //1 Open test site by URL
        homePage.open();

        //2 Assert Browser title
        homePage.checkTitle();

        //3 Perform login
        homePage.login(PITER_CHAILOVSKII);

        //4 Assert User name in the left-top side of screen that user is logged
        homePage.checkLoggedUserName(PITER_CHAILOVSKII);

        //5 Open through the header menu Service -> Dates Page
        homePage.openDatesPageThroughTheHeaderMenu();

        //6 Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most right position
        datesPageSelenide.setSlidersPosition(0, 100);

        //7 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPageSelenide.checkSlidersSettingLog(0, 100);

        //8 Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most left position.
        datesPageSelenide.setSlidersPosition(0, 0);

        //9 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPageSelenide.checkSlidersSettingLog(0, 0);

        //10 Using drag-and-drop set Range sliders. left sliders - the most right position, right slider - the most right position.
        datesPageSelenide.setSlidersPosition(100, 100);

        //11 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPageSelenide.checkSlidersSettingLog(100, 100);

        //12 Using drag-and-drop set Range sliders: from 30 to 70.
        datesPageSelenide.setSlidersPosition(30, 70);

        //13 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPageSelenide.checkSlidersSettingLog(30, 70);
    }
}
