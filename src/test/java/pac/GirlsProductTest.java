package pac;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
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
        /*
        ChoiceFootwearType  no argument, use TASK filter "туфли"
        ChoiceFootwearType(2) -зимняя обувь
        ChoiceFootwearType(3) -кроссовки
        ChoiceFootwearType(4) -босоножки
        ChoiceFootwearType(5) -демисезонная обувь
        ChoiceFootwearType(6) -туфли
        ChoiceFootwearType(7) -мокасины
        ChoiceFootwearType(8) -школьная обувь
        ChoiceFootwearType(9) -ортопедические берцы


         */
        girlsPage.ChoiceFootwearType();

        List<String> girlShoes;
        int count = 0;
        if (girlsPage.GetPageCount() == 0)
            count = 1;
        else
            count = girlsPage.GetPageCount();

        for (int i = 0; i < count; i++) {

            girlShoes = girlsPage.OpenAllProduct();
            for (String w : girlShoes
                    ) {
                Assert.assertTrue(w.matches("^[а-я, 0-9]+.+"));

            }

        }

    }

    @AfterTest
    public void AfterTest() {
        driver.close();
    }


}
