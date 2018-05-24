package pac;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import pac.PageObject.*;

public class MainTest {

    public WebDriver driver;

    //Number of products to check
    final int CountOfTestSale = 3;



    @BeforeTest
    public void BeforeTest() {
        System.setProperty("webdriver.chrome.driver", "C://Chromedriver//chromedriver.exe");
        this.driver = new ChromeDriver();


    }


    @Test
    public void testTitle() {
        MainPage searchJeansPage = new MainPage(this.driver);
        searchJeansPage.Navigate();
        String title = driver.getTitle();
        String expectTitle = "Интернет магазин детской обуви Foksi (Woopy Orthopedic Украина, Minime, Tofino)";
        Assert.assertEquals(title, expectTitle);
    }


    @Test
    public void CheckTreeProductSalePrice() {
        SalePage salePage = new SalePage(this.driver);
        salePage.Navigate();

        String[] Links = salePage.GetOneProductSaleLink(CountOfTestSale);
        for (int i = 0; i < CountOfTestSale; i++) {

            System.out.println(Links[i]);
            driver.get(Links[i]);


            Assert.assertTrue(salePage.GetOldPrice().isDisplayed());

        }
    }


    @AfterTest
    public void AfterTest() {
        driver.close();
    }

}







