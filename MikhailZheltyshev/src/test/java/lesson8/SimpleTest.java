package lesson8;

import org.testng.annotations.Test;

import static site.JdiExampleSite.login;
import static site.JdiExampleSite.homePage;


public class SimpleTest extends SimpleTestsInit {

    @Test
    public void loginTest() {
        homePage.open();
        //login();
        homePage.checkOpened();

    }
}
