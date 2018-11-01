package hwappium;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverSetup {
    protected AndroidDriver driver;

    protected void prepareNative() throws MalformedURLException { // exception required by java.net.URL
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //mandatory capabilities
        //capabilities.setCapability("device","Android"); // mandatory???????
        capabilities.setCapability("deviceName","aaf89146");
        capabilities.setCapability("platformName","Android");

        File app = new File("C:\\Users\\mihal\\Documents\\GitHub\\MikhailZheltyshev\\MikhailZheltyshev","ContactManager.apk");

        capabilities.setCapability("app", app.getAbsolutePath());

        // Init driver for local Appium server with capabilities have been set
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }

    protected void prepareAndroidWeb() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //mandatory Android capabilities
        capabilities.setCapability("deviceName","aaf89146");
        capabilities.setCapability("platformName","Android");

        // specific web capabilities
        capabilities.setCapability("browserName", "Chrome");
        //capabilities.setCapability("browserName", "Browser");

        // Init driver for local Appium server with capabilities have been set
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
                capabilities);

    }
}

