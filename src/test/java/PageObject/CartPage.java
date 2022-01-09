package PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    protected WebDriver driver;
    private By checkoutBy = By.id("checkout");

    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    public void atCartPage(){
        String header = driver.findElement(By.cssSelector("span.title")).getText();
        Assert.assertEquals("YOUR CART", header);
    }

    public void gotoCheckout(){
        driver.findElement(checkoutBy).click();
    }
}
