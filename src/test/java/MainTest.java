import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MainTest {

    @Test
    public void testSum() {
        SumTwoDigit gight = new SumTwoDigit();
        int a = gight.GetSum(3, 6);
        int b = 9;
        Assert.assertEquals(a, b);
    }


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