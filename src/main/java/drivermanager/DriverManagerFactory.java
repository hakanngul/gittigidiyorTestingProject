package drivermanager;


public class DriverManagerFactory {

    public static DriverManager getManager() {
        return new ChromeDriverManager();
    }

}
