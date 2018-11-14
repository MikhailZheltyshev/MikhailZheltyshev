package appium_enums;

public enum AdditionalCaps {
    APP_PACKAGE_CAP("appPackage"),
    APP_ACTIVITY_CAP("appActivity");

    public String capName;

    AdditionalCaps(String capability){
        this.capName = capability;
    }

}
