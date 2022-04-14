package PageObject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestLogin {
    WebDriver driver;
    Actions actions;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        actions = new Actions(driver);
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void testLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.atLoginPage();
        loginPage.loginUser("standard_user", "secret_sauce");
    }
    @Test
    public void testInventory(){

        testLogin();
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.atInventoryPage();
        inventoryPage.setAddToCartBy("add-to-cart-sauce-labs-backpack");
        inventoryPage.addToCart();
        inventoryPage.goToCart();
    }

    @Test
    public void testCartPage(){
        testInventory();
        CartPage cartPage = new CartPage(driver);
        cartPage.atCartPage();
        cartPage.gotoCheckout();
    }
    @Test
    public void testCheckoutPage(){
        testCartPage();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.atCheckoutPage();
        checkoutPage.inputDetails("Bob", "Builder", 11111);
    }
    @Test
    public void testCheckoutPage2(){
        testCheckoutPage();
        CheckoutPage2 checkoutPage2 = new CheckoutPage2(driver);
        checkoutPage2.atCheckoutPage2();
        checkoutPage2.clickFinish();
    }

    @After
    public void teardown(){
        driver.quit();
    }
}
