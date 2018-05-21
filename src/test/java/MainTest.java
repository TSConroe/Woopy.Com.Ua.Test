import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTest {


    @Test
    public void testTitle() {
        System.setProperty("webdriver.chrome.driver", "C://Chromedriver//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.woopy.com.ua/");
        String Title = driver.getTitle();
        String ExpectTitle = "Интернет магазин детской обуви Foksi (Woopy Orthopedic Украина, Minime, Tofino)";
        Assert.assertEquals(Title, ExpectTitle);
    }
}