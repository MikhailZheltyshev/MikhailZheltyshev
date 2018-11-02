package lesson8;

import org.testng.annotations.Test;

import static enums.Users.PITER_CHAILOVSKII;
import static site.JdiExampleSite.homePage;
import static site.JdiExampleSite.login;


public class SimpleTest extends SimpleTestsInit {

    @Test
    public void loginTest() {
        homePage.open();
        login(PITER_CHAILOVSKII);
        homePage.checkOpened();

    }
}
