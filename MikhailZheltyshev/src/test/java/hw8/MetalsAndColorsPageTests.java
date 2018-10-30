package hw8;

import dataProviders.DataProviders;
import jsonPojo.TestData;
import org.testng.annotations.Test;

import static enums.Users.PITER_CHAILOVSKII;
import static site.JdiExampleSite.*;


public class MetalsAndColorsPageTests extends MetalsAndColorsPageInit {


    @Test(dataProvider = "checkMetalsAndColorsPageDataProvider", dataProviderClass = DataProviders.class)
    public void loginTest(TestData data) throws InterruptedException {
        homePage.open();
        homePage.checkOpened();
        login();
        checkLoggedInUserName(PITER_CHAILOVSKII.displayName);
        openMetalAndColorsPageByHeader();
        metalAndColorsPage.summary.odds.select(3);
        metalAndColorsPage.summary.even.select(6);
        metalAndColorsPage.nature.select(data.getElements());
        metalAndColorsPage.colors.select(data.getColor());
        metalAndColorsPage.metals.select(data.getMetals());
        //metalAndColorsPage.vegetables.select("Onion");

        Thread.sleep(2000);

    }
}
