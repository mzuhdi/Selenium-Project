package locating.elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import static org.junit.Assert.assertTrue;

public class LocatingElementsTest {
    @Test
    public void elementsQuiz1(){

        //Find the chromedriver
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        //Instantiate the driver
        WebDriver driver = new ChromeDriver();
        //Navigate to url
        driver.get("https://www.saucedemo.com");
        //Find element and check state
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("userName")));
        //take action + record result
        //assertTrue(element.isDisplayed());
        //quit the driver
        driver.quit();
    }

}
