package hw8;

import dataProviders.DataProviders;
import jsonPojo.TestData;
import org.testng.annotations.Test;

import static enums.Users.*;
import static site.JdiExampleSite.*;


public class MetalsAndColorsPageTests extends MetalsAndColorsPageInit {


    @Test(dataProvider = "checkMetalsAndColorsPageDataProvider", dataProviderClass = DataProviders.class)
    public void loginTest(TestData data) throws InterruptedException {
        homePage.open();
        homePage.checkOpened();
        login();
        checkLoggedInUserName(PITER_CHAILOVSKII.displayName);
        openMetalAndColorsPageByHeader();
        metalAndColorsPage.colors.select(data.getColor());
        metalAndColorsPage.metals.select(data.getMetals());
        //metalAndColorsPage.vegetables.select("Onion");
        metalAndColorsPage.nature.select(data.getElements());

        Thread.sleep(2000);

    }
}
