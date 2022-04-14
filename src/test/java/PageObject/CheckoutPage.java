package PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    protected WebDriver driver;
    private By firstNameBy = By.id("first-name");
    private By lastNameBy = By.id("last-name");
    private By postalCodeBy = By.id("postal-code");
    private By continueButtonBy = By.id("continue");

    public CheckoutPage (WebDriver driver){
        this.driver = driver;
    }
    public void atCheckoutPage(){
        String headerTitle = driver.findElement(By.cssSelector("span.title")).getText();
        Assert.assertEquals("CHECKOUT: YOUR INFORMATION", headerTitle);
    }

    public void inputDetails (String firstName, String lastName, int postalCode){
        driver.findElement(firstNameBy).sendKeys(firstName);
        driver.findElement(lastNameBy).sendKeys(lastName);
        driver.findElement(postalCodeBy).sendKeys(String.valueOf(postalCode));
        driver.findElement(continueButtonBy).click();
    }
}
