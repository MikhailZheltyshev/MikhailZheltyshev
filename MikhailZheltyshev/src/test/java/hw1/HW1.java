package hw1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HW1 {

    @Test
    public void homeWork1() {

        //0 Init new browser instance
        WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        //1 Navigate to the Test site
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //2 Assert Browser Title
        assertEquals(driver.getTitle(), "Home Page");

        //3 Perform login
        driver.findElement(By.cssSelector(".profile-photo")).click();
        driver.findElement(By.cssSelector("[id = 'Name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id = 'Password']")).sendKeys("1234");
        driver.findElement(By.cssSelector(".login [type = 'submit']")).click();

        //4 Assert User is Logged in
        WebElement loggedUserNameElement = driver.findElement(By.cssSelector(".profile-photo span"));
        assertTrue(loggedUserNameElement.isDisplayed());
        assertEquals(loggedUserNameElement.getText(), "PITER CHAILOVSKII");

        //5 Assert Browser Title
        assertEquals(driver.getTitle(), "Home Page");



    }
}
