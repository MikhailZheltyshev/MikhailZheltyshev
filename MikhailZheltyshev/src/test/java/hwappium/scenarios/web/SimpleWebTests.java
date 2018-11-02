package hwappium.scenarios.web;

import appium.setup.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.io.IOException;

@Test(groups = "web")
public class SimpleWebTests extends Driver {
    protected SimpleWebTests() throws IOException {
        super();
    }

    @Test(description = "Open website")
    public void webTest() throws Exception {
        driver().get(SUT);
        // this always ends OK; it's a drawback.
        driverWait().until(ExpectedConditions.urlToBe(SUT+"/"));
        System.out.println("Site opening done");
    }

}
