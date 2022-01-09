package locating.elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WebDriverMethodsTest {
    WebDriver driver;
    WebElement element;
    JavascriptExecutor javascriptExecutor;
    Actions actions;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        javascriptExecutor = ((JavascriptExecutor) driver);
        actions = new Actions(driver);
    }

    @After
    public void teardown(){
        driver.quit();
    }

    @Test
    public void actions(){
        driver.get("https://example.cypress.io/commands/actions");
        element = driver.findElement(By.cssSelector(".action-focus"));
        element.click();
        Assert.assertEquals("form-control action-focus focus", element.getAttribute("class"));
    }

    @Test
    public void cookies(){
        driver.get("https://example.cypress.io/commands/cookies");
        element = driver.findElement(By.xpath("(//button[@class='set-a-cookie btn btn-success'])[1]"));
        element.click();
        Cookie cookie = driver.manage().getCookieNamed("token");
        Assert.assertEquals("123ABC", cookie.getValue());
    }
    @Test
    public void scrollToBottom() throws InterruptedException {
        driver.get("https://www.browserstack.com/guide/javascriptexecutor-in-selenium");
        javascriptExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(3000);
    }
    @Test
    public void scrollToUp() throws InterruptedException {
        driver.get("https://ultimateqa.com/complicated-page");
        javascriptExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        javascriptExecutor.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
        Thread.sleep(3000);
    }
}
