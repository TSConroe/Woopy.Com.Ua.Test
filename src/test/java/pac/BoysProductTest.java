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



public class BoysProductTest {

    public WebDriver driver;



    @BeforeTest
    public void BeforeTest() {
        System.setProperty("webdriver.chrome.driver", "C://Chromedriver//chromedriver.exe");
        this.driver = new ChromeDriver();



    }

    @Test
    public void BoysShowAllNotSneakersNumbers() {
        BoysPage boysPage = new BoysPage(this.driver);
        boysPage.Navigate();
        boysPage.СhoiceFootwearType(3);


        for (int i = 0; i < boysPage.GetPageCount()-1; i++) {

            boysPage.GetNumbersToNotSneakersShoes();


        }


    }

    @Test
    public void BoysTwoProductCheck() {
        BoysPage boysPage = new BoysPage(this.driver);
        boysPage.Navigate();
      //  boysPage.СhoiceFootwearType();




                /*
        ChoiceFootwearType  no argument, use TASK filter "кроссовки"
        ChoiceFootwearType(2) -зимняя обувь
        ChoiceFootwearType(3) -кроссовки
        ChoiceFootwearType(4) -босоножки
        ChoiceFootwearType(5) -демисезонная обувь
        ChoiceFootwearType(9) -туфли
        ChoiceFootwearType(6) -мокасины
        ChoiceFootwearType(7) -школьная обувь
        ChoiceFootwearType(8) -ортопедические берцы


         */
          boysPage.СhoiceFootwearType(2);



        int count =0;

        List<String> firstShoes = new ArrayList<>();

        if (boysPage.GetPageCount()==0)
            count =1;
        else
            count =boysPage.GetPageCount();

         for (int i = 0; i <count; i++) {

            firstShoes.addAll(boysPage.GetProductList());

        }

 // clear

        boysPage.СhoiceFootwearType(4);

        List<String> secondShoes = new ArrayList<>();

        if (boysPage.GetPageCount()==0)
            count =1;
        else
            count =boysPage.GetPageCount();


            for (int i = 0; i < count; i++) {

                secondShoes.addAll(boysPage.GetProductList());

            }


// clear

        boysPage.СhoiceFootwearType(2,4);


        List<String> seconplusfirstdShoes = new ArrayList<>();
        if (boysPage.GetPageCount()==0)
            count =1;
        else
            count =boysPage.GetPageCount();

            for (int i = 0; i < count; i++) {

                seconplusfirstdShoes.addAll(boysPage.GetProductList());

            }




        List<String> firstplussecond = new ArrayList<>();
        firstplussecond.addAll(secondShoes);
        firstplussecond.addAll(firstShoes);

        Collections.sort(firstplussecond);
        Collections.sort(seconplusfirstdShoes);

        if (firstplussecond.size() != seconplusfirstdShoes.size()) {
            if (firstplussecond.size() > seconplusfirstdShoes.size()) {
                int a = firstplussecond.size() - seconplusfirstdShoes.size();
                System.out.println("Different product");

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


