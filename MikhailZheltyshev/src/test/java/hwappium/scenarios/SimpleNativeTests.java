package hwappium.scenarios;

import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class SimpleNativeTests extends Hooks {
    protected SimpleNativeTests() {
        super();
    }

    @Test(description = "Just click on button 'Add contact'",
            groups = "native")
    public void simplestTest() throws Exception {
        String app_package_name = "com.example.android.contactmanager:id/";
        By add_btn = By.id(app_package_name + "addContactButton");
        driver().findElement(add_btn).click();
        // The result of clicking doesn't checked.
        System.out.println("Simplest Appium test done");
    }
}
