package drivermanager;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager implements DriverInterface {

    protected WebDriver driver;
    protected abstract void startService();
    protected abstract void stopService();
    protected abstract void createDriver();

    public void quitDriver() {
        if (null != driver) {
            driver.quit();
            driver = null;
        }
    }

    public WebDriver getDriver() {
        if (null == driver) {
            System.out.println("Driver Manager Çalışmaya Başladı");
            startService();
            createDriver();
        }
        return driver;
    }





}
