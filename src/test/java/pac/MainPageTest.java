package pac;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import pac.PageObject.*;

public class MainPageTest {

    public WebDriver driver;

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




    @AfterTest
    public void AfterTest() {
        driver.close();
    }

}







