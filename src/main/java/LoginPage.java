import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    private static final By emailLocator = By.id("L-UserNameField");
    private static final By passwordLocator = By.id("L-PasswordField");
    private static final By loginLocator = By.id("gg-login-enter");
    private static final By mainPageLocator = By.xpath("//*[@id='MainCon']/div/div[1]/a");

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void setEmail(String emailText) {
        type(emailLocator, emailText);
    }

    public void setPassword(String passwordText) {
        type(passwordLocator, passwordText);
    }

    public void clickLogin() {
        click(loginLocator);
    }

    public String getEmail() {
        return find(emailLocator).getAttribute("value");
    }

    public String getPassword() {
        return find(passwordLocator).getAttribute("value");
    }

    public void goMainPage() {
        click(mainPageLocator);
    }

}
