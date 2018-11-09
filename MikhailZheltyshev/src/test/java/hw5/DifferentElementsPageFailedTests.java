package hw5;

import base.SelenideTestBase;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import listeners.AllureAttachmentListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.DifferentElementsPageSelenide;
import pageObjects.HomePageSelenide;
import ru.yandex.qatools.allure.annotations.Issue;

import static com.codeborne.selenide.Selenide.page;
import static enums.DIfferentElementsPageCheckBoxes.*;
import static enums.DifferentElementsPageDropDownItems.YELLOW;
import static enums.DifferentElementsPageRadioButtons.SELEN;
import static enums.Users.PITER_CHAILOVSKII;

@Feature("UI Tests")
@Story("Failed Different Elements Page Testing")
@Listeners(AllureAttachmentListener.class)
public class DifferentElementsPageFailedTests extends SelenideTestBase {

    private HomePageSelenide homePage;
    private DifferentElementsPageSelenide differentElementsPage;

    @BeforeClass
    public void beforeClass() {
        homePage = page(HomePageSelenide.class);
        differentElementsPage = page(DifferentElementsPageSelenide.class);
    }

    @Issue("Wrong [EARTH,FIRE] checkboxes checked to fail test")
    @Test
    public void differentElementsPageInterfaceCheckFailed() {

        //1 Open test site by URL
        homePage.open();

        //2 Assert Browser title
        homePage.checkTitle();

        //3 Perform login
        homePage.login(PITER_CHAILOVSKII);

        //4 Assert User name in the left-top side of screen that user is logged
        homePage.checkLoggedUserName(PITER_CHAILOVSKII);

        //5 Click on "Service" subcategory in the header and check that drop down contains options
        homePage.checkUpperServiceMenuContent();

        //6 Click on Service subcategory in the left section and check that drop down contains options
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
        differentElementsPage.selectCheckBoxes(true, WATER, WIND);

        //12 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        differentElementsPage.checkLoggingOfCheckBoxes(true, WATER, WIND);

        //13 Select radio
        differentElementsPage.selectRadioButton(SELEN);

        //14 Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton. 
        differentElementsPage.checkLoggingOfRadioButtons(SELEN);

        //15 Select in dropdown
        differentElementsPage.selectItemFromDropDownMenu(YELLOW);

        //16 Assert that for dropdown there is a log row and value is corresponded to the selected value 
        differentElementsPage.checkLoggingOfDropDownMenu(YELLOW);

        //17 Unselect and assert checkboxes
        differentElementsPage.selectCheckBoxes(false, WATER, WIND);

        //18 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        differentElementsPage.checkLoggingOfCheckBoxes(false, EARTH, FIRE);
    }
}
