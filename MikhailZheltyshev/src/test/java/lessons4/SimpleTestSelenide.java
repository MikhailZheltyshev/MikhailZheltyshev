package lessons4;

import base.SelenideTestBase;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;

public class SimpleTestSelenide extends SelenideTestBase {

    @Test
    public void simpleTest() {
        setProperty("webdriver.chrome.driver","chromedriver.exe");

        //2 Navigate
        open("https://epam.github.io/JDI/index.html");

        //3 Assert Title
        assertEquals(getWebDriver().getTitle(), "Home Page");

        //4 Login
        $(".profile-photo").click();
        $("[id = 'Name']").sendKeys("epam");
        $("[id = 'Password']").sendKeys("1234");
        $(".login [type = 'submit']").click();

        SelenideElement mainTitle = $("h3.main-title");
        mainTitle.shouldBe(visible);
        mainTitle.shouldHave(text("EPAM FRAMEWORK WISHES…"));

        //6 Check 4 images
        $$(".benefit-txt").shouldHaveSize(4);
        $$(".benefit-txt").shouldBe(CollectionCondition.sizeLessThan(5));
    }
}
