package hwappium.scenarios;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

@Test(groups = "web")
public class SimpleWebTests extends Hooks {
    protected SimpleWebTests() {
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
