package locating.elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

//import static org.junit.Assert.assertTrue;

public class LocatingElementsTest {
    //Class variable so it can be used in other methods to run test
    WebDriver driver;

    //Before Annotation allows this to run before the Test annotation
    @Before
    public void setupClass(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void elementsQuiz1(){

        //Find the chromedriver

        //Instantiate the driver
        driver = new ChromeDriver();
        //Navigate to url
        driver.get("https://www.saucedemo.com");
        //Find element and check state
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("userName")));
        //take action + record result
        //assertTrue(element.isDisplayed());
        //quit the driver
    }

    @Test
    public void typesOfLocators(){
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");

        WebElement element = this.driver.findElement(By.id("user-name"));
        driver.findElement(By.className("input_error"));
        driver.findElement(By.name("user-name"));
        driver.findElement(By.tagName("input"));
        driver.findElement(By.cssSelector("#user-name"));
        driver.findElement(By.xpath("//*[@id=\"user-name\"]"));

        driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");

        driver.findElement(By.linkText("Click me using this link text!"));
        driver.findElement(By.partialLinkText("Click me using this"));

    }

    @Test
    public void locatorExam(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://saucedemo.com/");

        //Use CSS Selectors
        driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("input[data-test='password']")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("#login-button")).click();

        //Use XPath
        driver.findElement(By.xpath("//*button[@id='add-to-cart-sauce-labs-backpack']")).click();
        driver.findElement(By.xpath("//*a[@class='shopping_cart_link']")).click();
        driver.findElement(By.xpath("//*[@id='checkout'")).click();

        //use the best locator


    }

}
