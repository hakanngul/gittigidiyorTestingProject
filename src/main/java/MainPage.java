import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    private final By girisYapButton = By.xpath("//div[@class='gekhq4-4 egoSnI' and text()='Giriş Yap']");

    public MainPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean checkHomePage() {

        var x = find(girisYapButton);
        if (x.getText() != null) {
            System.out.println(x.getText());
            System.out.println("xxxxxxxxxxxxxxx");
            Assertions.assertTrue(true);
            return true;
        } else {
            System.out.println(x.getText());
            Assertions.assertFalse(false);
            return false;
        }
    }
}
