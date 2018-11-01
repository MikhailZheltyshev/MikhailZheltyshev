package hwappium;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSimpleTest extends DriverSetup {

    @BeforeMethod
    public void setUp() throws Exception {
        prepareNative();
        //prepareAndroidWeb();
    }

    @Test
    public void SimplestTest() throws InterruptedException {
        By add_btn_id = By.id("com.example.android.contactmanager:id/addContactButton");
        By add_btn_xpath = By.xpath("//android.widget.Button[@content-desc='Add Contact']");
        By add_btn_class_name = By.className("android.widget.Button");
        driver.findElement(add_btn_xpath).click();
        System.out.println("Simplest Appium test done");
        Thread.sleep(1000);
    }

    @Test(description = "Open website")
    public void webTest() throws InterruptedException {
        driver.get("http://iana.org");
        Thread.sleep(5000);
        System.out.println("Site opening done");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}


