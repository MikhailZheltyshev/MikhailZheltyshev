package base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.setProperty;

public class TestBase {

    private long time;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(){
        setProperty("webdriver.chrome.driver", "chromedriver.exe");
        time = currentTimeMillis();
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite(){
        System.out.println("Test duration: " + (currentTimeMillis() - time));
    }
}
