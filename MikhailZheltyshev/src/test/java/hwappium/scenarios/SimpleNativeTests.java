package hwappium.scenarios;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

@Test(groups = "native")
public class SimpleNativeTests extends Hooks {
    protected SimpleNativeTests() {
        super();
    }

    @Test(description = "Just click on button 'Add contact' and check titles")
    public void clickAddContactTest() throws Exception {
        String app_package_name = "com.example.android.contactmanager:id/";
        By add_btn = By.id(app_package_name + "addContactButton");
        driver().findElement(add_btn).click();
        By add_contact_title = By.id("android:id/title");
        Assert.assertTrue(driver().findElement(add_contact_title).isDisplayed());

        By target_account_title = By.id("Target Account");
        By contact_name_title = By.id("Contact Name");
        By contact_phone_title = By.id("Contact Phone");
        By contact_email_title = By.id("Contact Email");

        List<By> desiredTitles = Arrays.asList(target_account_title, contact_name_title,
                contact_phone_title, contact_email_title);
        for (By title : desiredTitles) {
            Assert.assertTrue(driver().findElement(title).isDisplayed());
        }

        System.out.println("Simplest Appium test done");
    }
}