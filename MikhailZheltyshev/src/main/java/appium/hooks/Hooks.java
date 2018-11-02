package appium.hooks;

import appium.setup.Driver;
import appium.setup.PropertyFile;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

@Test(groups = {"native","web"})
public class Hooks extends Driver {
    @BeforeSuite(groups = {"web"})
    void setWeb() throws Exception {
        setPropertyFile(PropertyFile.WEB);
        prepareDriver();
    }

    @BeforeSuite(groups = {"native"})
    void setNative() throws Exception {
        setPropertyFile(PropertyFile.NATIVE);
        prepareDriver();
    }

    @BeforeSuite(groups = {"hybrid"})
    void setHybrid() throws Exception {
        setPropertyFile(PropertyFile.HYBRID);
        prepareDriver();
    }

    @AfterSuite(description = "Close driver on all tests completion",
            alwaysRun = true
    )
    public void tearDown() throws Exception {
        driver().quit();
        System.out.println("Driver closed");
    }
}
