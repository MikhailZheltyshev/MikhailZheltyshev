package setup;

public enum PropertyFile {

    NATIVE("nativetests"),
    WEB("webtests"),
    HYBRID("hybridtests");

    private String currentAppType;

    PropertyFile(String current) {
        this.currentAppType = current;
    }

    public String getFileName() {
        return currentAppType + ".properties";
    }
}