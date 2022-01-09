package PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage {

    protected WebDriver driver;

    private By addToCartBy;
    private By shoppingCartBy = By.className("shopping_cart_link");

    public InventoryPage(WebDriver driver){
        this.driver = driver;
    }

    public void atInventoryPage(){
        String headerTitle = driver.findElement(By.cssSelector("span.title")).getText();
        Assert.assertEquals("PRODUCTS",headerTitle);
    }

    public By setAddToCartBy(String id){
        return addToCartBy = By.id(id);
    }

    public void addToCart(){
        driver.findElement(addToCartBy).click();
    }

    public void goToCart(){
        driver.findElement(shoppingCartBy).click();
    }
}
