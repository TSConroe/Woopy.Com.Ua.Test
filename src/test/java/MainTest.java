import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Random;


public class MainTest {

    public WebDriver driver;
    final int CountOfTestSale = 3;

    @Test
    public void testTitle() {
        driver.get("https://www.woopy.com.ua/");
        String Title = driver.getTitle();
        String ExpectTitle = "Интернет магазин детской обуви Foksi (Woopy Orthopedic Украина, Minime, Tofino)";
        Assert.assertEquals(Title, ExpectTitle);
    }

    @BeforeTest
    public void BeforeTest() {
        System.setProperty("webdriver.chrome.driver", "C://Chromedriver//chromedriver.exe");
        driver = new ChromeDriver();


    }

    @AfterTest
    public void AfterTest() {
        driver.close();
    }

    @Test
    public void SalePriceCheck() {
        driver.get("https://www.woopy.com.ua/index.php/component/virtuemart/view/category/virtuemart_category_id/8");
        List<WebElement> elements = driver.findElements(By.xpath("//*[@class=\'product-readmore\']//a"));

        for (int i=0; i < CountOfTestSale; i++) {
            Random rand = new Random();
            WebElement randomElement = elements.get(rand.nextInt(elements.size()));
            System.out.println(randomElement.getAttribute("href"));
                       }


    }
}

