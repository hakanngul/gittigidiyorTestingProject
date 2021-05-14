import drivermanager.DriverInterface;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import Model.CustomLogger;

public class BasePage implements DriverInterface {

    CustomLogger customLogger = CustomLogger.getInstance();

    public BasePage() {
        PageFactory.initElements(driver, this);
        BasicConfigurator.configure();

    }

    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public void click(By locator) {

        var x = find(locator);
//        System.out.println(x.getAttribute("value")+ " Clicked!");
        customLogger.info(x.getAttribute("value")+ " Clicked!");
        x.click();
    }

    public void type(By locator, String text) {
        var x = find(locator);
        customLogger.info(x.getAttribute("value")+ " send to"+ " "+ text );
        x.sendKeys(text);
    }


    public void scrollToEnd() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

    }

    public void scrollToElement(By locator) throws InterruptedException {
        WebElement element = find(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);

    }


}
