package hwappium.nativetests;

import hwappium.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

    @Test(description = "Click on the button 'Add contact' and check content of opened screen")
    public void simplestAddContactScreenTest() throws Exception {
        String app_package_name = "com.example.android.contactmanager:id/";
        By add_btn = By.id(app_package_name + "addContactButton");
        driver().findElement(add_btn).click();
        By add_contact_title = By.id("android:id/title");

        //Check that "Add contact" title is displayed
        Assert.assertTrue(driver().findElement(add_contact_title).isDisplayed());

        //WebElements for each title
        WebElement target_account_title = driver().findElement(By.id("Target Account"));
        WebElement contact_name_title = driver().findElement(By.id("Contact Name"));
        WebElement contact_phone_title = driver().findElement(By.id("Contact Phone"));
        WebElement contact_email_title = driver().findElement(By.id("Contact Email"));

        //List of WebElements for fields titles
        List<WebElement> desiredTitles = Arrays.asList(target_account_title, contact_name_title,
                contact_phone_title, contact_email_title);
        List<String> expectedTitles = Arrays.asList("Target Account", "Contact Name",
                "Contact Phone", "Contact Email");

        //Iterate through the titles in List<WebElement> to check each title is displayed
        for (WebElement title : desiredTitles) {
            Assert.assertTrue(title.isDisplayed());
        }
        //Assert titles have expected texts
        for (int i = 0 ; i < expectedTitles.size(); i++){
            Assert.assertEquals(desiredTitles.get(i).getText(),expectedTitles.get(i));
        }

        WebElement target_account_spinner = driver().findElement(By.id(app_package_name + "accountSpinner"));
        WebElement contact_name_field = driver().findElement(By.id(app_package_name + "contactNameEditText"));
        WebElement contact_phone_field = driver().findElement(By.id(app_package_name + "contactPhoneEditText"));
        WebElement contact_email_field = driver().findElement(By.id(app_package_name + "contactEmailEditText"));

        //Assert all expected fields are displayed
        Assert.assertTrue(target_account_spinner.isDisplayed());
        Assert.assertTrue(contact_name_field.isDisplayed());
        Assert.assertTrue(contact_phone_field.isDisplayed());
        Assert.assertTrue(contact_email_field.isDisplayed());

        System.out.println("Simplest Appium test done");
    }
}
