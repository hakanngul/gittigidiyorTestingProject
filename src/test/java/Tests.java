import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Tests extends BaseTest {
    String email = "EmailAdresi";
    String password = "Parola";
    String productName = "Bilgisayar";
    String baseUrl = "https://www.gittigidiyor.com/";
    String urunSayisi = "2";
    @Order(1)
    @Test
    public void Login() {
        driver.get(baseUrl.concat("uye-girisi"));
        loginPage.setEmail(this.email);
        Assertions.assertEquals(this.email, loginPage.getEmail(), "Email Bilgisi Hatalıdır.");
        loginPage.setPassword(this.password);
        Assertions.assertEquals(this.password, loginPage.getPassword(), "Şifre Hatalıdır");
        loginPage.clickLogin();
    }

    @Order(2)
    @Test
    public void goSearch() {
        findProduct.setProduct(this.productName);
        findProduct.goProduct();
        findProduct.scrollToEnd();
        findProduct.goSecondPage();
    }

    @Order(3)
    @Test
    public void findRandomProductAndGoBasket() throws InterruptedException {
        findProduct.goSelectedProduct();
        basketPage.getFirstPrice(true);
        basketPage.addToBasket();
        Thread.sleep(1500);
    }

    @Order(4)
    @Test
    public void goBasket() throws InterruptedException {
        basketPage.goBasket();
        Thread.sleep(500);
        basketPage.getFirstPrice(false);
        basketPage.comparisonPrice();
    }
    @Order(5)
    @Test
    public void changeProductCount() throws InterruptedException {
        basketPage.getProductCount(this.urunSayisi);
        Thread.sleep(500);

    }
    @Order(6)
    @Test
    public void  checkProductCount() throws InterruptedException {
        var x = basketPage.checkProductCount();
        Assertions.assertEquals(this.urunSayisi, x);
        Thread.sleep(300);
    }

    @Order(7)
    @Test
    public void clearBasket() throws InterruptedException {
        Thread.sleep(2000);
        basketPage.clearBasket();
        Thread.sleep(2000);
    }
}
