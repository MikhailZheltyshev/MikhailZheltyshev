package hw8;

import base.MetalsAndColorsPageInit;
import dataProviders.DataProviders;
import jsonPojo.TestData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static enums.Users.PITER_CHAILOVSKII;
import static org.testng.Assert.*;
import static site.JdiExampleSite.*;


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

        //6 Select summary radio-buttons using data-provider values
        metalAndColorsPage.selectSummary(data.getSummaryOdd(),data.getSummaryEven());

        //7 Select nature element check-box using data-provider values
        metalAndColorsPage.selectElements(data.getElements());

        //8 Select color from the Colors drop-down menu using data-provider values
        metalAndColorsPage.selectColor(data.getColor());

        //9 Select metal from the Metals drop-down menu using data-provider values
        metalAndColorsPage.selectMetal(data.getMetal());

        //10 Select vegetables from the Vegetables drop-list
        metalAndColorsPage.selectVegetables(data.getVegetables());

        //11 Click on Submit button
        metalAndColorsPage.clickSubmit();

        //12 Assert the results list displayed is corresponding to the previously selected values
        assertEquals(metalAndColorsPage.getActualResult(),
                metalAndColorsPage.getExpectedResult(data));
    }
}
