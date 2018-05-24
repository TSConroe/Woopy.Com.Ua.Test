package pac;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


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


    @Test
    public void BoysShowAllNotSneakersNumbers() {
        BoysPage boysPage = new BoysPage(this.driver);
        boysPage.Navigate();

        boysPage.СhoiceFootwearType();


        for (int i = 0; i < boysPage.GetPageCount()-1; i++) {

            boysPage.GetNumbersToNotSneakersShoes();


        }


    }

    @Test
    public void BoysTwoProductCheck() {
        BoysPage boysPage = new BoysPage(this.driver);
        boysPage.Navigate();
        driver.get("https://www.woopy.com.ua/index.php/component/virtuemart/view/category/virtuemart_category_id/6");

        boysPage.СhoiceFootwearType();
        List<String> firstShoes = boysPage.GetProductList();

        //next pages
        for (int i = 0; i < boysPage.GetPageCount() - 1; i++) {
            boysPage.NexPage();
            firstShoes.addAll(boysPage.GetProductList());

        }
        System.out.println(firstShoes.size() + "one");


// clear


        boysPage.СhoiceMoks();

        List<String> secondShoes = boysPage.GetProductList();

        //next
        //next pages
        if (boysPage.GetPageCount() > 0) {
            for (int i = 0; i < boysPage.GetPageCount() - 1; i++) {
                boysPage.NexPage();
                secondShoes.addAll(boysPage.GetProductList());

            }
        }
        System.out.println(secondShoes.size() + "two");


        // clear

        boysPage.СhoiceMoksAndSneakers();
        List<String> seconplusfirstdShoes = boysPage.GetProductList();
        if (boysPage.GetPageCount() > 0) {
            for (int i = 0; i < boysPage.GetPageCount() - 1; i++) {
                boysPage.NexPage();
                seconplusfirstdShoes.addAll(boysPage.GetProductList());

            }


        }

        System.out.println(seconplusfirstdShoes.size() + "one+two");


        List<String> firstplussecond = new ArrayList<>();
        firstplussecond.addAll(secondShoes);
        firstplussecond.addAll(firstShoes);

        Collections.sort(firstplussecond);
        Collections.sort(seconplusfirstdShoes);

        if (firstplussecond.size() != seconplusfirstdShoes.size()) {
            if (firstplussecond.size() > seconplusfirstdShoes.size()) {
                int a = firstplussecond.size() - seconplusfirstdShoes.size();

                for (int i = a; i > 0; i--) {
                    System.out.println(firstplussecond.get(firstplussecond.size() - i));
                }
            }
            if (firstplussecond.size() < seconplusfirstdShoes.size()) {
                int a = firstplussecond.size() - seconplusfirstdShoes.size();

                for (int i = a; i > 0; i--) {
                    System.out.println(firstplussecond.get(firstplussecond.size() - i));
                }
            }
        }


        Assert.assertEquals((firstShoes.size() + secondShoes.size()), seconplusfirstdShoes.size());


    }


    @AfterTest
    public void AfterTest() {
        driver.close();
    }

}







