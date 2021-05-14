package drivermanager;

import org.openqa.selenium.WebDriver;

public interface DriverInterface {

    DriverManager driverManager = DriverManagerFactory.getManager();
    WebDriver driver = driverManager.getDriver();
}
