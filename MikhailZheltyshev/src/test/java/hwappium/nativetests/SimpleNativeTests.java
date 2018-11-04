package hwappium.nativetests;

import hwappium.Hooks;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.PropertyFile;

import java.util.Arrays;
import java.util.List;

@Test(groups = "native")
public class SimpleNativeTests extends Hooks {

    protected SimpleNativeTests() {
        super(PropertyFile.NATIVE);
    }

    @Test(description = "Click on the button 'Add contact' and make sure all contact fields appear")
    public void simplestTest() throws Exception {
        String app_package_name = "com.example.android.contactmanager:id/";
        By add_btn = By.id(app_package_name + "addContactButton");
        driver().findElement(add_btn).click();
        By add_contact_title = By.id("android:id/title");

        //Check that "Add contact" title is displayed
        Assert.assertTrue(driver().findElement(add_contact_title).isDisplayed());

        //Bys for field titles
        By target_account_title = By.id("Target Account");
        By contact_name_title = By.id("Contact Name");
        By contact_phone_title = By.id("Contact Phone");
        By contact_email_title = By.id("Contact Email");

        //List of By's for fields titles
        List<By> desiredTitles = Arrays.asList(target_account_title, contact_name_title,
                contact_phone_title, contact_email_title);

        //Iterate to check each title is displayed
        for (By title : desiredTitles) {
            Assert.assertTrue(driver().findElement(title).isDisplayed());
        }

        System.out.println("Simplest Appium test done");
    }
}
