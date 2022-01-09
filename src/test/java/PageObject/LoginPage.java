package PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    protected WebDriver driver;

    private By usernameBy = By.id("user-name");
    private By passwordBy = By.id("password");
    private By loginBy = By.id("login-button");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void atLoginPage(){
        WebElement loginButton = driver.findElement(loginBy);
        Assert.assertTrue(loginButton.isDisplayed());
    }

    public void loginUser(String username, String password){
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(loginBy).click();
    }
}
