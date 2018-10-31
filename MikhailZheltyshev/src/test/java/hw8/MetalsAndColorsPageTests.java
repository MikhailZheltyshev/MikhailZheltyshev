package hw8;

import dataProviders.DataProviders;
import jsonPojo.TestData;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static enums.Users.PITER_CHAILOVSKII;
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
        checkLoggedInUserName(PITER_CHAILOVSKII.displayName);

        //5 Open Metals And Colors Page by the Header menu
        openMetalAndColorsPageByHeader();

        //6 Select summary radio-buttons using data-provider values
        metalAndColorsPage.summary.odds.select(String.valueOf(data.getSummary()[0]));
        metalAndColorsPage.summary.even.select(String.valueOf(data.getSummary()[1]));

        //7 Select nature element check-box using data-provider values
        metalAndColorsPage.nature.select(data.getElements());

        //8 Select color from the Colors drop-down menu using data-provider values
        metalAndColorsPage.colors.select(data.getColor());

        //8 Select metal from the Metals drop-down menu using data-provider values
        metalAndColorsPage.metals.select(data.getMetals());

        //9 Select vegetables from the Vegetables drop-list
        metalAndColorsPage.selectVegetables(data.getVegetables());

        //10 Click on Submit button
        metalAndColorsPage.submitBtn.click();

        //11 Assert the results list displayed is corresponding to the previously selected values
        Assert.assertEquals(metalAndColorsPage.resultsList.getTextList(), metalAndColorsPage.getExpectedResultTextList(data));
    }

    @Test()
    public void metalsColorsTest1() {

        //1 Open Home Page
        homePage.open();

        //2 Check Home Page is opened
        homePage.checkOpened();

        //3 Login as PITER CHAILOVSKI
        login();

        //4 Check User Name corresponds to the logged user
        checkLoggedInUserName(PITER_CHAILOVSKII.displayName);

        //5 Open Metals And Colors Page by the Header menu
        openMetalAndColorsPageByHeader();

        //6 Select summary radio-buttons using data-provider values
        metalAndColorsPage.summary.odds.select(String.valueOf(1));
        metalAndColorsPage.summary.even.select(String.valueOf(2));

        //7 Select nature element check-box using data-provider values
        metalAndColorsPage.nature.select("Water");

        //8 Select color from the Colors drop-down menu using data-provider values
        metalAndColorsPage.colors.select("Red");

        //8 Select metal from the Metals drop-down menu using data-provider values
        metalAndColorsPage.metals.select("Gold");

        //9 Select vegetables from the Vegetables drop-list - DOESN'T WORK:(
        //metalAndColorsPage.vegetables.select("Onion");
        metalAndColorsPage.selectVegetables("Onion","Tomato");

        //10 Click on Submit button
        metalAndColorsPage.submitBtn.click();

        //11 Assert the results list displayed is corresponding to the previously selected values
       // Assert.assertEquals(metalAndColorsPage.resultsList.getTextList(), metalAndColorsPage.getExpectedResultTextList(data));
    }
}
