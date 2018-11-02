package appium.hooks;

import appium.setup.Driver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class Hooks extends Driver {
    /**
     * Required variables will be initialized by inherited constructor
     * @throws IOException
     */
    Hooks() throws IOException {
        super();
    }

    @BeforeSuite(description = "Prepare driver to run test(s)")
    public void setUp() throws Exception {
        prepareDriver();
        System.out.println("Driver prepared");

    }

    @AfterSuite(description = "Close driver on all tests completion")
    public void tearDown() throws Exception {
        driver().quit();
        System.out.println("Driver closed");
    }
}
