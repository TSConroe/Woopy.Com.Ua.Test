package pac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pac.MainPage;

import java.util.List;
import java.util.Random;


public class MainTest {

    public WebDriver driver;
    final int CountOfTestSale = 3;
    String url = "https://www.woopy.com.ua";

    @BeforeTest
    public void BeforeTest() {
        System.setProperty("webdriver.chrome.driver", "C://Chromedriver//chromedriver.exe");
        this.driver = new ChromeDriver();


    }


    @Test
    public void testTitle() {
       MainPage searchJeansPage = new MainPage(this.driver);
       searchJeansPage.Navigate(url);
        String Title = driver.getTitle();
        String ExpectTitle = "Интернет магазин детской обуви Foksi (Woopy Orthopedic Украина, Minime, Tofino)";
        Assert.assertEquals(Title, ExpectTitle);
    }


   @Test
    public void SalePriceCheck() {
       SalePage salePage = new SalePage(this.driver);
       salePage.Navigate(url);
       driver.get("https://www.woopy.com.ua/index.php/component/virtuemart/view/category/virtuemart_category_id/8");
       String[] Links = salePage.GetOneProductSaleLink(CountOfTestSale);
       for (int i = 0; i < CountOfTestSale; i++) {

           System.out.println(Links[i]);
           driver.get(Links[i]);
           Assert.assertTrue(driver.findElement(By.className("old-price")).isDisplayed());

       }
   }

    @Test
    public void GirlsPriceCheck() {
        GirlsPage girlsPage = new GirlsPage(this.driver);
        girlsPage.Navigate(url);
        driver.get("https://www.woopy.com.ua/index.php/component/virtuemart/view/category/virtuemart_category_id/7");
        girlsPage.ClearFilter();
        Assert.assertTrue(girlsPage.OpenAllProduct());

    }
    @Test
    public void BoysPriceCheck() {
        BoysPage boysPage = new BoysPage(this.driver);
        boysPage.Navigate(url);
        driver.get("https://www.woopy.com.ua/index.php/component/virtuemart/view/category/virtuemart_category_id/6");
        boysPage.ClearFilter();
        boysPage.OpenAllProduct();


    }




    @AfterTest
    public void AfterTest() {
      //  driver.close();
    }

                       }







