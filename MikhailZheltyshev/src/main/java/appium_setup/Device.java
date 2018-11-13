package appium_setup;

public class Device {
    public String aut; // (mobile) app under testing
    public String sut; // site under testing
    public String test_platform;
    public String driver;
    public String device_name;
    public String udid;
    public String app_package;
    public String app_activity;

    public boolean isRemote;


    @Override
    public String toString() {
        return "Device{" +
                "aut='" + aut + '\'' +
                ", sut='" + sut + '\'' +
                ", test_platform='" + test_platform + '\'' +
                ", driver='" + driver + '\'' +
                ", device_name='" + device_name + '\'' +
                ", isRemote=" + isRemote +
                ", udid='" + udid + '\'' +
                ", app_package='" + app_package + '\'' +
                ", app_activity='" + app_activity + '\'' +
                '}';
    }

    public boolean isRemote() {
        return isRemote;
    }

    public void setRemote(boolean remote) {
        isRemote = remote;
    }

    public String getAut() {
        return aut;
    }

    public void setAut(String aut) {
        this.aut = aut;
    }

    public String getSut() {
        return sut;
    }

    public void setSut(String sut) {
        this.sut = sut;
    }

    public String getTest_platform() {
        return test_platform;
    }

    public void setTest_platform(String test_platform) {
        this.test_platform = test_platform;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getDevice_name() {
        return device_name;
    }

    public void setDevice_name(String device_name) {
        this.device_name = device_name;
    }

    public String getUdid() {
        return udid;
    }

    public void setUdid(String udid) {
        this.udid = udid;
    }

    public String getApp_package() {
        return app_package;
    }

    public void setApp_package(String app_package) {
        this.app_package = app_package;
    }

    public String getApp_activity() {
        return app_activity;
    }

    public void setApp_activity(String app_activity) {
        this.app_activity = app_activity;
    }
}
