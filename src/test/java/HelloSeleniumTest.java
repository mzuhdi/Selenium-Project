import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloSeleniumTest {
    public void firstTest(){
        System.setProperty("webdriver.chrome.driver","resources/chromerdriver");
        WebDriver driver = new ChromeDriver();
    }
}
