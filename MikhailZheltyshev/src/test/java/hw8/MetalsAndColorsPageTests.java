package hw8;

import base.MetalsAndColorsPageInit;
import dataProviders.DataProviders;
import jsonPojo.TestData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import site.JdiExampleSite;

import static enums.Users.PITER_CHAILOVSKII;
import static enums.jdi.Pages.METALS_AND_COLORS;
import static site.JdiExampleSite.homePage;
import static site.JdiExampleSite.metalAndColorsPage;
import static utils.MetalAndColorPageResultsHandler.checkResult;


public class MetalsAndColorsPageTests extends MetalsAndColorsPageInit {

    @AfterMethod()
    public void tearDown() {
        homePage.clearCache();
    }

    @Test(dataProvider = "checkMetalsAndColorsPageDataProvider", dataProviderClass = DataProviders.class)
    public void metalsColorsTest(TestData formFillData) {

        //1 Open Home Page
        homePage.open();

        //2 Check Home Page is opened
        homePage.checkOpened();

        //3 Login as PITER CHAILOVSKI
        JdiExampleSite.login(PITER_CHAILOVSKII);

        //4 Check User Name corresponds to the logged user
        JdiExampleSite.checkLoggedInUserName(PITER_CHAILOVSKII);

        //5 Open Metals And Colors Page by the Header menu
        JdiExampleSite.openPageByHeader(METALS_AND_COLORS);

        //6 Fill Metals And Colors Form using data provided
        metalAndColorsPage.metalsAndColorsForm.fill(formFillData);

        //7 Submit Metals And Colors Form
        metalAndColorsPage.metalsAndColorsForm.submit();

        //8 Assert the results list displayed is corresponding to the previously selected values
        checkResult(formFillData);
    }
}
