package hw8;

import org.testng.annotations.Test;

import static enums.Users.*;
import static site.JdiExampleSite.*;


public class MetalsAndColorsPageTests extends MetalsAndColorsPageInit {



    @Test
    public void loginTest() throws InterruptedException {
        homePage.open();
        homePage.checkOpened();
        login();
        checkLoggedInUserName(PITER_CHAILOVSKII.displayName);
        openMetalAndColorsPageByHeader();
        metalAndColorsPage.colors.select("Blue");
        metalAndColorsPage.metals.select("Gold");
        //metalAndColorsPage.vegetables.select("Onion");
        metalAndColorsPage.nature.select("Fire","Water");
        Thread.sleep(10000);

    }
}
