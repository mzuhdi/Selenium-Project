import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class UsingWebDriverManager {
    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.edgedriver().setup();
    }
    @Test
    public void startTest(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.close();
    }
    @Test
    public void assignmentOne(){
        WebDriver chromeDriver = new ChromeDriver();
        WebDriver edgeDriver = new EdgeDriver();

        edgeDriver.get("https://the-internet.herokuapp.com/");
        chromeDriver.get("https://example.cypress.io/");
        chromeDriver.get("https://react-shopping-cart-67954.firebaseapp.com/");
    }

    @Test
    public void assignmentOneAnswer() throws InterruptedException{
        WebDriver edgeDriver = new EdgeDriver();
        edgeDriver.get("https://the-internet.herokuapp.com/");
        Thread.sleep(3000);
        edgeDriver.quit();
    }

}
