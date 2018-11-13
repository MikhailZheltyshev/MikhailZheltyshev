package appium_setup;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;

public class Driver {
    private static AppiumDriver driverSingle = null;
    private static WebDriverWait waitSingle;
    private DesiredCapabilities capabilities;
    private static Device device;

    // Properties to be read
    private static String AUT; // (mobile) app under testing
    protected static String SUT; // site under testing
    private static String TEST_PLATFORM;
    private static String DRIVER;
    private static String DEVICE_NAME;
    private static String UDID;
    private static String APP_PACKAGE;
    private static String APP_ACTIVITY;

    protected void loadConfig(String pathToConfig) throws FileNotFoundException {
        System.out.println("Config: " + pathToConfig); //Write current config file name to console
        JsonObject jDevice = new JsonParser().parse(new FileReader
                (pathToConfig)).getAsJsonObject();
        device = new Gson().fromJson(jDevice, Device.class);

        System.out.println(device);
        String resourcePath = "./src/main/resources/";
        AUT = device.aut == null ? null :  resourcePath + device.aut;
        System.out.println("aut=" + AUT); //Write Current AUT to console
        SUT = device.sut == null ? null : "https://" + device.sut;
        System.out.println("sut=" + SUT); //Write Current SUT to console
        TEST_PLATFORM = device.test_platform;
        DRIVER = device.driver;
        DEVICE_NAME = device.device_name;
        UDID = device.udid;
        APP_PACKAGE = device.app_package;
        APP_ACTIVITY = device.app_activity;
    }

    protected void prepareDriver() throws Exception {
        capabilities = new DesiredCapabilities();
        String browserName;

        //Check type of test platform to set proper browserName capability
        switch (TEST_PLATFORM) {
            case "Android":
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
                browserName = "Chrome";
                break;
            case "iOS":
                capabilities.setCapability(MobileCapabilityType.UDID,UDID);
                browserName = "Safari";
                break;
            default:
                throw new Exception("Unknown mobile platform");
        }
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, TEST_PLATFORM);

        //Check for test config type to set corresponding capabilities for WEB/NATIVE test
        //If SUT null and AUT is not null - we deal with NATIVE test
        if (AUT != null && SUT == null) {
            //Check if device is remote (located on farm) to use proper capabilities to load apk
            if(device.isRemote) {
                capabilities.setCapability("appPackage", APP_PACKAGE);
                capabilities.setCapability("appActivity", APP_ACTIVITY);
            } else {
                File app = new File(AUT);
                capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
            }
            //And if opposite - we deal with WEB test
        } else if (SUT != null && AUT == null) {
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);
        } else {
            throw new Exception("Unclear type of mobile app");
        }
        // Init driver with new AppiumDriver object
        if (driverSingle == null) driverSingle = new AppiumDriver(new URL(DRIVER), capabilities);

        // Set an object to handle timeouts
        if (waitSingle == null) waitSingle = new WebDriverWait(driver(), 10);

    }

    //Method to access singleton
    protected AppiumDriver driver() throws Exception {
        if (driverSingle == null) prepareDriver();
        return driverSingle;
    }

    protected WebDriverWait driverWait() {
        return waitSingle;
    }

}