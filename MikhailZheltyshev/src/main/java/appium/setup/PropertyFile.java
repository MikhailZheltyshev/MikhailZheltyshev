package appium.setup;

public enum PropertyFile {
    NATIVE("nativetests"), WEB("webtests"), HYBRID("hybrid");

    private String currentAppType;

    PropertyFile(String current) {
        this.currentAppType = current;
    }

    public String getName() {
        return currentAppType + ".properties";
    }

}