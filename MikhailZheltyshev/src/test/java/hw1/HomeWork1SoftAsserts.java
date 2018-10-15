package hw1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import org.testng.asserts.SoftAssert;


public class HomeWork1SoftAsserts {

    private SoftAssert soft = new SoftAssert();

    @Test
    public void testJdiIndexPage() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        //1 Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //2 Assert Browser Title
        soft.assertEquals(driver.getTitle(), "Home Page");

        //3 Perform login
        driver.findElement(By.cssSelector(".profile-photo")).click();
        driver.findElement(By.cssSelector("[id = 'Name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id = 'Password']")).sendKeys("1234");
        driver.findElement(By.cssSelector(".login [type = 'submit']")).click();

        //4 Assert User name in the left-top side of screen that user is loggined
        WebElement loggedUserNameElement = driver.findElement(By.cssSelector(".profile-photo span"));
        soft.assertTrue(loggedUserNameElement.isDisplayed());
        soft.assertEquals(loggedUserNameElement.getText(), "PITER CHAILOVSKII");

        //5 Assert Browser Title
        soft.assertEquals(driver.getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        //6.1 Getting List<WebElement> of Menu Buttons
        List<WebElement> upperToolbarItems = driver.findElements(By.cssSelector("ul.uui-navigation.nav.navbar-nav.m-l8 > li"));

        //6.2 Assert There are 4 Browser Up-Level Buttons And They Are displayed
        soft.assertEquals(upperToolbarItems.size(), 4);
        for (WebElement item: upperToolbarItems){
            soft.assertTrue(item.isDisplayed());
        }

        //6.3 Assert Browser Up-Level Buttons Have Proper Text
        soft.assertEquals(upperToolbarItems.get(0).getText(), "HOME");
        soft.assertEquals(upperToolbarItems.get(1).getText(), "CONTACT FORM");
        soft.assertEquals(upperToolbarItems.get(2).getText(), "SERVICE");
        soft.assertEquals(upperToolbarItems.get(3).getText(), "METALS & COLORS");

        //7 Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> benefitIconElements = driver.findElements(By.cssSelector(".benefit-icon"));
        soft.assertEquals(benefitIconElements.size(), 4);
        for (WebElement icon: benefitIconElements){
            soft.assertTrue(icon.isDisplayed());
        }

        //8 Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> textsUnderIconsElements = driver.findElements(By.cssSelector(".benefit-txt"));
        soft.assertEquals(textsUnderIconsElements.size(), 4);
        soft.assertEquals(textsUnderIconsElements.get(0).getText(),"To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project");
        soft.assertEquals(textsUnderIconsElements.get(1).getText(),"To be flexible and\n" +
                "customizable");
        soft.assertEquals(textsUnderIconsElements.get(2).getText(),"To be multiplatform");
        soft.assertEquals(textsUnderIconsElements.get(3).getText(),"Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…");

        //9 Assert a text of the main header
        String mainHeaderText = driver.findElement(By.cssSelector("h3.main-title.text-center")).getText();
        soft.assertEquals(mainHeaderText, "EPAM FRAMEWORK WISHES…");
        String mainSubHeaderText = driver.findElement(By.cssSelector(".main-txt.text-center")).getText();
        soft.assertEquals(mainSubHeaderText, "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD" +
                " TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION" +
                " ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN" +
                " VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        //10 Assertthat there is the iframe in the center of page
        soft.assertTrue(driver.findElement( By.id("iframe") ).isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        driver.switchTo().frame("iframe");
        soft.assertTrue(driver.findElement( By.id("epam_logo") ).isDisplayed());

        //12 Switch to original window back
        driver.switchTo().defaultContent();

        //13 Assert a text of the sub header
        String defaultHeaderText = driver.findElement(By.cssSelector("[class='text-center']")).getText();
        soft.assertEquals(defaultHeaderText, "JDI GITHUB");

        //14 Assert that JDI GITHUB is a link and has a proper URL
        WebElement linkToJDIGitHub = driver.findElement(By.cssSelector("[class='text-center'] a"));
        soft.assertTrue(linkToJDIGitHub.isDisplayed());
        soft.assertEquals(linkToJDIGitHub.getAttribute("href"), "https://github.com/epam/JDI");

        //15 Assert that there is Left Section
        WebElement navSideBarElement = driver.findElement(By.name("navigation-sidebar"));
        soft.assertTrue(navSideBarElement.isDisplayed());

        //16 Assert that there is Footer
        soft.assertTrue(driver.findElement(By.cssSelector("footer")).isDisplayed());

        //17 Perform assertion of all soft asserts in the test and close browser
        soft.assertAll();
        driver.close();
    }
}

