package PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage2 {

    protected WebDriver driver;
    private By finishButtonBy = By.id("finish");

    public CheckoutPage2(WebDriver driver){
        this.driver = driver;
    }
    public void atCheckoutPage2(){
        String headerTitle = driver.findElement(By.cssSelector("span.title")).getText();
        Assert.assertEquals("CHECKOUT: OVERVIEW", headerTitle);
    }

    public void clickFinish(){
        driver.findElement(finishButtonBy).click();
    }
}
