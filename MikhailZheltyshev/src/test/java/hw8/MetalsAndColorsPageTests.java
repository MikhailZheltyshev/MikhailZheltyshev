package hw8;

import enums.Users;
import org.testng.annotations.Test;

import static enums.Users.*;
import static site.JdiExampleSite.*;


public class MetalsAndColorsPageTests extends MetalsAndColorsPageInit {

    @Test
    public void loginTest() {
        homePage.open();
        homePage.checkOpened();
        login();
        checkLoggedInUserName(PITER_CHAILOVSKII.displayName);
        openMetalAndColorsPageByHeader();
        metalAndColorsPage.checkOpened();

    }
}
