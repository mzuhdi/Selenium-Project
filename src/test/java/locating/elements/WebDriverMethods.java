package locating.elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverMethods {
    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void webDriverMethodsQuiz() throws InterruptedException {
        Actions action = new Actions(driver);

        driver.get("https://the-internet.herokuapp.com/dropdown");
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        dropdown.selectByIndex(0);
        Assert.assertTrue(driver.findElement(By.cssSelector("[value='1']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("[value='2']")).isSelected());

        driver.get("https://the-internet.herokuapp.com/hovers");
        WebElement firstAvatar = driver.findElement(By.xpath("(//img[@alt='User Avatar'])[1]"));
        action.moveToElement(firstAvatar).build().perform();
        Assert.assertTrue(firstAvatar.isDisplayed());

        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement box = driver.findElement(By.id("hot-spot"));
        action.contextClick(box).build().perform();
        driver.switchTo().alert().accept();

        driver.get("https://the-internet.herokuapp.com/key_presses");
        WebElement input = driver.findElement(By.id("target"));
        action.sendKeys(input, Keys.ARROW_RIGHT).build().perform();
        //Assert.assertTrue(driver.findElement(By.id("result")).getText().contentEquals("You entered: RIGHT"));
        WebElement result = driver.findElement(By.id("result"));
        Assert.assertEquals("Input right arrow key", "You entered: RIGHT", result.getText());

        driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");
        WebElement icon = driver.findElement(By.linkText("Clickable Icon"));
        action.moveToElement(icon).build().perform();
        Assert.assertTrue(icon.getAttribute("href").contentEquals("https://ultimateqa.com/link-success/"));
        String cssValue = icon.getCssValue("background-origin");
        Assert.assertTrue(cssValue.contentEquals("padding-box"));

    }
}
