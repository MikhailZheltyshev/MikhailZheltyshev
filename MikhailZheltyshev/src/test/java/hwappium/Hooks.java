package hwappium;

import appium_setup.Driver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Test(groups = {"native","web"})
public class Hooks extends Driver {

    @BeforeSuite(description = "Prepare driver to run test(s)")
    @Parameters("pathToConfig")
    public void setUp(String pathToConfig) throws Exception {
        loadConfig(pathToConfig);
        prepareDriver();
        System.out.println("Driver prepared");

    }

    @AfterSuite(description = "Close driver on all tests completion")
    public void tearDown() throws Exception {
        driver().quit();
        System.out.println("Driver closed");
    }
}
