package pac;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pac.PageObject.*;

public class SaleProductTest {

    public WebDriver driver;

    //Number of products to check
    final int CountOfTestSale = 3;



    @BeforeTest
    public void BeforeTest() {
        System.setProperty("webdriver.chrome.driver", "C://Chromedriver//chromedriver.exe");
        this.driver = new ChromeDriver();


    }


    @Test
    public void CheckTreeProductSalePrice() {
        SalePage salePage = new SalePage(this.driver);
        salePage.Navigate();

        String[] Links = salePage.GetOneProductSaleLink(CountOfTestSale);
        for (int i = 0; i < CountOfTestSale; i++) {

            driver.get(Links[i]);

            Assert.assertTrue(salePage.GetOldPrice().isDisplayed());

        }
    }


    @AfterTest
    public void AfterTest() {
        driver.close();
    }

}