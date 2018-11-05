package appium_setup;

public enum PropertyFile {
    /**
     * Enum for building property name with respect to the selected test configuration
     */
    NATIVE("nativetests"),
    WEB("webtests");

    private String currentAppType;

    // Constructor to allow Enum to store corresponding String with AppType value fot test preparations
    PropertyFile(String current) {
        this.currentAppType = current;
    }

    // Method to build proper property file name depends on AppType type is running
    public String getFileName() {
        return currentAppType + ".properties";
    }
}