package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.setProperty;

public class TestBaseForHw2Ex3 {

    protected WebDriver driver;

    @BeforeSuite()
    public void beforeSuite(){
        setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }

    @BeforeClass()
    public void beforeClass(){
        driver = new ChromeDriver();
    }

    @AfterClass()
    public void afterClass(){
        driver.close();
    }

    @AfterSuite()
    public void afterSuite(){
        System.out.println(currentTimeMillis());
    }
}
