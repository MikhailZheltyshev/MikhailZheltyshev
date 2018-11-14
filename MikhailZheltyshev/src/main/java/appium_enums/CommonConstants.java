package appium_enums;

public enum CommonConstants {
    PATH_TO_RESOURCES("./src/main/resources/"),
    HTTPS_PREFIX("https://");

    public String value;

    CommonConstants(String value){
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
