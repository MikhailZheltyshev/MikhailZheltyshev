package hw1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
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

        //6 Assert Menu Buttons Are Displayed And Have Proper Text
        //6.1 Get List of Menu Buttons
        List<WebElement> upperToolbarItems = driver.findElements(By.cssSelector(".uui-navigation.nav.navbar-nav.m-l8 li"));

        //6.2 Assert Browser Up-Level Buttons Are displayed
        assertTrue(upperToolbarItems.get(0).isDisplayed());
        assertTrue(upperToolbarItems.get(1).isDisplayed());
        assertTrue(upperToolbarItems.get(2).isDisplayed());
        assertTrue(upperToolbarItems.get(11).isDisplayed());

        //6.3 Assert Browser Up-Level Buttons Have Proper Text
        assertEquals(upperToolbarItems.get(0).getText(), "HOME");
        assertEquals(upperToolbarItems.get(1).getText(), "CONTACT FORM");
        assertEquals(upperToolbarItems.get(2).getText(), "SERVICE");
        assertEquals(upperToolbarItems.get(11).getText(), "METALS & COLORS");

        //7 Assert that 4 icons are presented and displayed on the index page
        List<WebElement> benefitIconElements = driver.findElements(By.cssSelector(".benefit-icon"));
        assertEquals(benefitIconElements.size(), 4);
        for (WebElement icon: benefitIconElements){
            assertTrue(icon.isDisplayed());
        }

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> textsUnderIconsElements = driver.findElements(By.cssSelector(".benefit-txt"));
        assertEquals(textsUnderIconsElements.size(), 4);
        assertEquals(textsUnderIconsElements.get(0).getText(),"To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project");
        assertEquals(textsUnderIconsElements.get(1).getText(),"To be flexible and\n" +
                "customizable");
        assertEquals(textsUnderIconsElements.get(2).getText(),"To be multiplatform");
        assertEquals(textsUnderIconsElements.get(3).getText(),"Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…");
    }
}
