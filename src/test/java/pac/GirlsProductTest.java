package pac;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import pac.PageObject.*;
public class GirlsProductTest {


    public WebDriver driver;

    @BeforeTest
    public void BeforeTest() {
        System.setProperty("webdriver.chrome.driver", "C://Chromedriver//chromedriver.exe");
        this.driver = new ChromeDriver();


    }

    @Test
    public void GirlsShoesCheck() {
        GirlsPage girlsPage = new GirlsPage(this.driver);
        girlsPage.Navigate();


        girlsPage.ChoiceFootwearType();
        List<String> girlShoes = girlsPage.OpenAllProduct();
        //firs page
        for (String w : girlShoes
                ) {
            //  System.out.println(w.getText());
            Assert.assertFalse(w.isEmpty());
        }
        //next pages
        for (int i = 0; i < girlsPage.GetPageCount() - 1; i++) {
            girlsPage.NexPage();
            girlShoes.addAll(girlsPage.OpenAllProduct());

            List<String> girlShoes2 = girlsPage.OpenAllProduct();

            for (String w : girlShoes2
                    ) {

                Assert.assertFalse(w.isEmpty());


            }
        }

    }


}
