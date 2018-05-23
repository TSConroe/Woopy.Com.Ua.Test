package pac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
    public void CheckTreeProductSalePrice() {
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
    public void GirlsShoesCheck() {
        GirlsPage girlsPage = new GirlsPage(this.driver);
        girlsPage.Navigate(url);
        driver.get("https://www.woopy.com.ua/index.php/component/virtuemart/view/category/virtuemart_category_id/7");
        girlsPage.ClearFilter();
        girlsPage.СhoiceFootwearType();
        List<WebElement> girlShoes = girlsPage.OpenAllProduct();
        //firs page
        for (WebElement w : girlShoes
                ) {
          //  System.out.println(w.getText());
            Assert.assertFalse(w.getText().isEmpty());
        }
        //next pages
            for (int i = 0; i < girlsPage.GetPageCount() - 1; i++) {
                girlsPage.NexPage();
                girlShoes.addAll(girlsPage.OpenAllProduct());

                List<WebElement> girlShoes2 = girlsPage.OpenAllProduct();

                for (WebElement w : girlShoes2
                        ) {
                //    System.out.println(w.getText());
                    Assert.assertFalse(w.getText().isEmpty());


                }
            }

        }






    @Test
    public void BoysPriceCheck() {
        BoysPage boysPage = new BoysPage(this.driver);
        boysPage.Navigate(url);
        driver.get("https://www.woopy.com.ua/index.php/component/virtuemart/view/category/virtuemart_category_id/6");
        boysPage.ClearFilter();
        boysPage.СhoiceFootwearType();
        boysPage.OpenAllProduct();


    }

    @Test
    public void BoysTwoProductCheck() {
        BoysPage boysPage = new BoysPage(this.driver);
        boysPage.Navigate(url);
        driver.get("https://www.woopy.com.ua/index.php/component/virtuemart/view/category/virtuemart_category_id/6");
        boysPage.ClearFilter();
        boysPage.СhoiceFootwearType();

         List<WebElement> firstList =boysPage.CountFootwer();
        for (int i = 0; i < firstList.size(); i++) {
            System.out.println(firstList.get(i));
        }

    }




    @AfterTest
    public void AfterTest() {
       driver.close();
    }

                       }







