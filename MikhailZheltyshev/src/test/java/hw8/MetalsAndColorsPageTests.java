package hw8;

import base.MetalsAndColorsPageInit;
import dataProviders.DataProviders;
import jsonPojo.TestData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static enums.Users.PITER_CHAILOVSKII;
import static site.JdiExampleSite.*;
import static utils.MetalAndColorPageResultsHandler.checkResult;


public class MetalsAndColorsPageTests extends MetalsAndColorsPageInit {

    @AfterMethod()
    public void tearDown() {
        homePage.clearCache();
    }

    @Test(dataProvider = "checkMetalsAndColorsPageDataProvider", dataProviderClass = DataProviders.class)
    public void metalsColorsTest(TestData data) {

        //1 Open Home Page
        homePage.open();

        //2 Check Home Page is opened
        homePage.checkOpened();

        //3 Login as PITER CHAILOVSKI
        login();

        //4 Check User Name corresponds to the logged user
        checkLoggedInUserName(PITER_CHAILOVSKII);

        //5 Open Metals And Colors Page by the Header menu
        openMetalAndColorsPageByHeader();

        //6 Fill Metals And Colors Form using data provided
        metalAndColorsPage.metalsAndColorsForm.fill(data);

        //7 Submit Metals And Colors Form
        metalAndColorsPage.metalsAndColorsForm.submit();

        //8 Assert the results list displayed is corresponding to the previously selected values
        checkResult(data);
    }
}
