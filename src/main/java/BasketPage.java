import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasketPage extends BasePage {
    private final By productCount = By.xpath("//div[@class='gg-input gg-input-select ']/select[@class='amount']");
    private final By firstPrice = By.xpath("//*[@id=\"sp-price-lowPrice\"]");
    private final By secondPrice = By.xpath("//div[@class='total-price']");
    private final By clearBasketLocator = By.xpath("//a[@title='Sil' and @class='btn-delete btn-update-item']");
    private final By addBasketButtonLocator = By.id("add-to-basket");
    private final By goBasketLocator = By.xpath("//*[@id=\"header_wrapper\"]/div[4]/div[3]/a/div[2]");


    private String firstPriceText = "";
    private String secondPriceText = "";

    public void goBasket() {
        click(goBasketLocator);
    }

    public void addToBasket() throws InterruptedException {
        scrollToElement(addBasketButtonLocator);
        click(addBasketButtonLocator);
    }

    public void clearBasket() {
        click(clearBasketLocator);
    }

    public void getProductCount(String deger) {
        var x = find(productCount);
        Select dropdown = new Select(x);
        System.out.println("******");
        dropdown.selectByValue(deger);
    }
    public String checkProductCount() {
        var x = find(productCount);
        Select dropdown = new Select(x);
        var option = dropdown.getFirstSelectedOption();
        var defaultItem = option.getText();
        return defaultItem;
    }

    public void getFirstPrice(boolean first) {

        if (first) {
            this.firstPriceText = find(firstPrice).getText();
            System.out.println("first Price " + this.firstPriceText);
        } else {

            this.secondPriceText = find(secondPrice).getText();
            System.out.println("second Price " + this.secondPriceText);

        }
    }

    public void comparisonPrice() {

        if (firstPriceText.equals(secondPriceText)) {
            System.out.println("First Price  --- :" + this.firstPriceText);
            System.out.println("Ürün Fiyatları Aynı");
        } else {
            System.out.println("Second Price --- :" + this.secondPriceText);
            System.out.println("Ürün Fiyatları Farklı");
        }
    }


}
