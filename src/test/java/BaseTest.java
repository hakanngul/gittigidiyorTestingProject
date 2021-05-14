import Model.CustomLogger;
import drivermanager.DriverInterface;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest implements DriverInterface {
    protected LoginPage loginPage = new LoginPage();
    protected FindProduct findProduct = new FindProduct();
    protected BasketPage basketPage = new BasketPage();
    protected MainPage indexPage = new MainPage();
    private static String baseUrl = "https://www.gittigidiyor.com/";
//    private static CustomLogger customLogger = CustomLogger.getInstance();


    @BeforeAll
    public static void setUp() {
//        customLogger.info("Drıver Started");
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterAll
    public static void tearDown() {
//        customLogger.info("Drıver Quit");
        driverManager.quitDriver();
    }


}
