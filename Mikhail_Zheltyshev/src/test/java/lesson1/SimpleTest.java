package lesson1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SimpleTest {

    @Test
    public void simpleTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://epam.github.io/JDI/index.html");
        //driver.close();
    }
}
