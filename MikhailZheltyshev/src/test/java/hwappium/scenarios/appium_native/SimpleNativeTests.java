package hwappium.scenarios.appium_native;

import appium.setup.Driver;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

@Test(groups = "native")
public class SimpleNativeTests extends Driver {
    protected SimpleNativeTests() throws IOException {
        super();
    }

    @Test(description = "Just click on button 'Add contact'")
    public void simplestTest() throws Exception {
        String app_package_name = "com.example.android.contactmanager:id/";
        By add_btn = By.id(app_package_name + "addContactButton");
        driver().findElement(add_btn).click();
        // The result of clicking doesn't checked.
        System.out.println("Simplest Appium test done");
    }
}
