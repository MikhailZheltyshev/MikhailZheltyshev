package hwappium.webtests;

import hwappium.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.PropertyFile;

import java.util.List;

@Test(groups = "web")
public class SimpleWebTests extends Hooks {

    protected SimpleWebTests() {
        super(PropertyFile.WEB);
    }

    @Test(description = "Open website")
    public void webTest() throws Exception {
        driver().get(SUT);
        driverWait().until(ExpectedConditions.urlToBe(SUT+"/"));
        WebElement header_logo = driver().findElement(By.cssSelector("h1"));
        //Assert header is displayed
        Assert.assertTrue(header_logo.isDisplayed());
        List<WebElement> sections = driver().findElements(By.cssSelector(".home-panel"));
        //Assert there 3 home-panels exist
        Assert.assertEquals(sections.size(),3);
        System.out.println("Site opening done");
    }
}
