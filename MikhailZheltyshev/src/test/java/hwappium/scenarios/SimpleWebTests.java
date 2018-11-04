package hwappium.scenarios;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test(groups = "web")
public class SimpleWebTests extends Hooks {
    protected SimpleWebTests() {
        super();
    }

    @Test(description = "Open website and check title")
    public void webTest() throws Exception {
        driver().get(SUT);
        driverWait().until(ExpectedConditions.urlToBe(SUT+"/"));
        WebElement header_logo = driver().findElement(By.cssSelector("h1"));
        Assert.assertTrue(header_logo.isDisplayed());
        System.out.println("Site opening done");
    }

}
