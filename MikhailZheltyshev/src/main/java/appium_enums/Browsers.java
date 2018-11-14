package appium_enums;

public enum Browsers {
    CHROME("Chrome"),
    SAFARI("Safari");

    public String browser;

    Browsers(String browserName) {
        this.browser = browserName;
    }
}
