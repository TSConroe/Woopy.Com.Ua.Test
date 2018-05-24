package pac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;




public class BoysPage {

    private WebDriver driver;
    String url = "https://www.woopy.com.ua";

    @FindBy(css = "#wrapper > div > div.catalog-menu > ul > li:nth-child(1) > a")
    public WebElement GirlsLink;

    @FindBy(xpath = "//*[@id=\"main\"]//div[3]/a")
    public WebElement ClearFilter;

    // @FindBy(xpath ="//*[@id=\"form_function\"]/div/div[1]/div[2]/label/div/div")

    @FindBy(css = "#form_function > div > div:nth-child(2) > div:nth-child(2) > label > div")
    public WebElement ShoesCheckBox;

    @FindBy(css = "#form_function > div > div:nth-child(2) > div:nth-child(3) > label > div")
    public WebElement SneakersCheckBox;

    @FindBy(css = "#form_function > div > div:nth-child(2) > div:nth-child(6) > label > div")
    public WebElement MoisksCheckBox;

    @FindBy(css = "#main > div.content > div.category-view > div.more-link-prod > form > a")
    public WebElement ShowMoreButton;
    @FindBy(xpath = "//*[@class=\"product-title\"]//a[1]")
    public List<WebElement> productName;
    @FindBy(xpath = "//*[@class=\"page-nav\"]//li")
    public List<WebElement> pageCount;

    public List<WebElement> orederNumber;

    //@FindBy(xpath ="//*[@class=\"product-title\"]//a[1]")
    public List<WebElement> firstproductName;

    public BoysPage(WebDriver browser) {
        this.driver = browser;
        //  this.driver.manage().window().fullscreen();
        PageFactory.initElements(browser, this);


    }

    public void NexPage() {
        ShowMoreButton.click();

    }

    public int GetPageCount() {

        List <WebElement> pageCount= driver.findElements(By.xpath("//*[@class=\"page-nav\"]//li"));
        int count = pageCount.size();
        return count;
    }

    public void Navigate(String Pageurl) {
        this.driver.navigate().to(this.url);
    }


    public void ClearFilter() {
        ClearFilter.click();
    }

    public void СhoiceFootwearType() {

        SneakersCheckBox.click();


    }
    public void СhoiceMoks( )
        {
            ClearFilter.click();
            MoisksCheckBox.click();
        }
        public void СhoiceMoksAndSneakers( ) {
            ClearFilter.click();
            MoisksCheckBox.click();
            SneakersCheckBox.click();

        }



    public List<WebElement> CountFootwer() {

        firstproductName = driver.findElements(By.xpath("//*[@class=\"product-title\"]//a"));
        System.out.println(firstproductName.size());
    for (int i=0; i<pageCount.size()-1; i++)
        {

            firstproductName.addAll( driver.findElements(By.xpath("//*[@class=\"product-title\"]//a")));
            ShowMoreButton.click();
            System.out.println(firstproductName.size());

        }


       return firstproductName;


    }

    public void GetNumbersToNotSneakersShoes()
    {
        productName = driver.findElements(By.xpath("//*[@class=\"product-title\"]//a[1]"));
        orederNumber =driver.findElements(By.xpath("//*[@class=\"order-number\"]//span"));

        for (int i = 0; i< productName.size(); i++
                ) {
          //  System.out.println(productName.get(i).getText());
            if (!"КРОССОВКИ".equalsIgnoreCase(productName.get(i).getText()))

                System.out.println(orederNumber.get(i).getText());


            }
        }

    public List<String> GetProductList() {

        orederNumber =driver.findElements(By.xpath("//*[@class=\"order-number\"]//span"));
        List <String> LinkList = new ArrayList<>();

        for (int i = 0; i < orederNumber.size(); i++)
        {
            LinkList.add(orederNumber.get(i).getText());

        }

        System.out.println(orederNumber.size() + "from boys page ");
        return LinkList;




    }






}

