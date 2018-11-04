package hwappium;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import setup.Driver;
import setup.PropertyFile;

@Test(groups = {"native","web"})
public class Hooks extends Driver {
    private PropertyFile currentProps;

    public Hooks(PropertyFile props) {
        this.currentProps = props;
    }

    @BeforeSuite(description = "Prepare driver to run test(s)")
    public void setUp() throws Exception {
        setPropertyFile(currentProps);
        prepareDriver();
        System.out.println("Driver prepared");

    }

    @AfterSuite(description = "Close driver on all tests completion")
    public void tearDown() throws Exception {
        driver().quit();
        System.out.println("Driver closed");
    }
}
