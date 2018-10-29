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
        metalAndColorsPage.nature.select("Fire","Water");
        metalAndColorsPage.summary.odds.select("5");
        //metalAndColorsPage.saladDL.select(0,1,2);
        metalAndColorsPage.submitBtn.click();
        System.out.println(metalAndColorsPage.resultsList.getText(1));
        Thread.sleep(10000);

    }
}
