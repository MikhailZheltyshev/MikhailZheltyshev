package appium.setup;

public enum PropertyFile {
    NATIVE("native"), WEB("web");

    private String currentAppType;

    PropertyFile(String current) {
        this.currentAppType = current;
    }

    public String getName() {
        return currentAppType + ".properties";
    }

}