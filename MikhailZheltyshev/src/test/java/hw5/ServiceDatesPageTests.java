package hw5;

import base.SelenideTestBase;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import listeners.AllureAttachmentListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.DatesPageSelenide;
import pageObjects.DifferentELementsPageSelenide;
import pageObjects.HomePageSelenide;

import static com.codeborne.selenide.Selenide.page;
import static enums.Urls.HOME_PAGE;
import static enums.Users.PITER_CHAILOVSKII;

@Feature("UI Tests")
@Story("Service And Dates Pages Testing")
@Listeners(AllureAttachmentListener.class)
public class ServiceDatesPageTests extends SelenideTestBase {

    @Test
    public void servicePageInterfaceCheckFailed() {

        HomePageSelenide homePage = page(HomePageSelenide.class);
        DifferentELementsPageSelenide differentElementsPage = page(DifferentELementsPageSelenide.class);
        //1 Open test site by URL
        homePage.open(HOME_PAGE.url);

        //2 Assert Browser title
        homePage.checkTitle();

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

        //7 Open through the header menu Service -> Different Elements Page
        homePage.openDifferentElementsPageThroughTheHeaderMenu();

        //8 Check interface on Different elements page, it contains all needed elements
        differentElementsPage.checkDifferentElementsPageContent();

        //9 Assert that there is Right Section
        differentElementsPage.checkRightSectionExists();

        //10 Assert that there is Left Section
        differentElementsPage.checkLeftSectionExists();

        //11 Select not expected checkboxes for FAILURE simulation
        differentElementsPage.selectEartAndFireCheckBoxes();

        //12 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        differentElementsPage.checkLoggingOfCheckBoxesChecked();

        //13 Select radio
        differentElementsPage.selectSelenRadioButton();

        //14 Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton. 
        differentElementsPage.checkLoggingOfRadioButtons();

        //15 Select in dropdown
        differentElementsPage.selectYellowFromDropDownMenu();

        //16 Assert that for dropdown there is a log row and value is corresponded to the selected value 
        differentElementsPage.checkLoggingOfDropDownMenu();

        //17 Unselect and assert checkboxes
        differentElementsPage.unselectWaterAndWindCheckBoxes();

        //18 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        differentElementsPage.checkLoggingOfCheckBoxesUnchecked();
    }

    @Test
    public void servicePageInterfaceCheck() {

        HomePageSelenide homePage = page(HomePageSelenide.class);
        DifferentELementsPageSelenide differentElementsPage = page(DifferentELementsPageSelenide.class);

        //1 Open test site by URL
        homePage.open(HOME_PAGE.url);

        //2 Assert Browser title
        homePage.checkTitle();

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

        //7 Open through the header menu Service -> Different Elements Page
        homePage.openDifferentElementsPageThroughTheHeaderMenu();

        //8 Check interface on Different elements page, it contains all needed elements
        differentElementsPage.checkDifferentElementsPageContent();

        //9 Assert that there is Right Section
        differentElementsPage.checkRightSectionExists();

        //10 Assert that there is Left Section
        differentElementsPage.checkLeftSectionExists();

        //11 Select checkboxes
        differentElementsPage.selectWaterAndWindCheckBoxes();

        //12 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        differentElementsPage.checkLoggingOfCheckBoxesChecked();

        //13 Select radio
        differentElementsPage.selectSelenRadioButton();

        //14 Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton. 
        differentElementsPage.checkLoggingOfRadioButtons();

        //15 Select in dropdown
        differentElementsPage.selectYellowFromDropDownMenu();

        //16 Assert that for dropdown there is a log row and value is corresponded to the selected value 
        differentElementsPage.checkLoggingOfDropDownMenu();

        //17 Unselect and assert checkboxes
        differentElementsPage.unselectWaterAndWindCheckBoxes();

        //18 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        differentElementsPage.checkLoggingOfCheckBoxesUnchecked();
    }

    @Test
    public void datesPageInterfaceCheck() {

        HomePageSelenide homePage = page(HomePageSelenide.class);
        DatesPageSelenide datesPageSelenide = page(DatesPageSelenide.class);

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

        //7 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPageSelenide.checkSlidersAreSetFrom0To100Log();

        //8 Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most left position.
        datesPageSelenide.setSlidersFrom0To0();

        //9 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPageSelenide.checkSlidersAreSetFrom0To0Log();

        //10 Using drag-and-drop set Range sliders. left sliders - the most rigth position, right slider - the most rigth position.
        datesPageSelenide.setSlidersFrom100To100();

        //11 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPageSelenide.checkSlidersAreSetFrom100To100Log();

        //12 Using drag-and-drop set Range sliders: from 30 to 70.
        datesPageSelenide.setSlidersFrom30To70();

        //13 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPageSelenide.checkSlidersAreSetFrom30To70Log();
    }

}
