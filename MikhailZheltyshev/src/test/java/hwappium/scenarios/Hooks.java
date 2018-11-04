package hwappium.scenarios;

import appium.setup.Driver;
import appium.setup.PropertyFile;
import org.testng.annotations.*;

@Test(groups = {"native","web"})
public class Hooks extends Driver {
    @BeforeSuite(groups = "web")
    void setWeb() throws Exception {
        System.out.println("I'm in WEB BeforeSuite");
        setPropertyFile(PropertyFile.WEB);
        prepareDriver();
    }

    @BeforeSuite(groups = "native")
    void setNative() throws Exception {
        System.out.println("I'm in NATIVE BeforeSuite");
        setPropertyFile(PropertyFile.NATIVE);
        prepareDriver();
    }

    @AfterSuite(description = "Close driver on all tests completion",
            groups = {"native","web"})
    public void tearDown() throws Exception {
        driver().quit();
        System.out.println("Driver closed");
    }
}
