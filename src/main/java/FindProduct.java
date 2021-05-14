import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class FindProduct extends BasePage {


    private final By searchBarLocator = By.xpath("//input[@data-cy='header-search-input' and @name='k']");
    private final By searchButtonLocator = By.xpath("//button[@data-cy='search-find-button' and @type='submit']");
    private final By secondPageLocator = By.xpath("//*[@id=\"best-match-right\"]/div[5]/ul/li[2]/a");



    public void goSelectedProduct() throws InterruptedException {
        var random = randomNumber(48);
        By randomProductLocator = By.xpath("//ul/li[@product-index=" + random + "]");
        scrollToElement(randomProductLocator);
        Thread.sleep(500);
        click(randomProductLocator);
    }

    public FindProduct() {
        PageFactory.initElements(driver, this);
    }

    public String randomNumber(int max) {
        Random r = new Random();
        int randomSayi = r.nextInt(max) + 1;
        return String.valueOf(randomSayi);
    }

    public void setProduct(String productName) {
        click(searchBarLocator);
        type(searchBarLocator, productName);
    }

    public void goProduct() {
        click(searchButtonLocator);
    }

    public void goSecondPage() {
        click(secondPageLocator);
    }

}
