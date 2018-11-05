package appium_helper;

import io.appium.java_client.AppiumDriver;

public class KeyBoardHelper {

    /**
     *
     * @param driver - driver object to execute .hideKeyboard() method
     * @return True on successful hiding of keyboard
     * and False on exception thrown by executing .hideKeyboard() method, which means
     * the driver didn't find any keyboard to hide.
     */
    public static boolean checkKeyBoardAppears(AppiumDriver driver) {
        try {
            driver.hideKeyboard();
            return true;
        } catch (Exception e) {
            System.out.println("No keyboard was found!");
            return false;
        }
    }
}
