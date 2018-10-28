package lesson8;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import org.testng.annotations.BeforeSuite;
import site.JdiExampleSite;

import static com.epam.jdi.uitests.core.settings.JDISettings.logger;

@SuppressWarnings("unchecked")
public class SimpleTestsInit extends TestNGBase {
    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        WebSite.init(JdiExampleSite.class);
        logger.info("Run Tests");
    }
}
