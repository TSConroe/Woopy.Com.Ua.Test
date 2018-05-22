package pac;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;


public class SalePage  {

    private WebDriver driver;
    String url = "https://www.woopy.com.ua";

    @FindBy(css ="#wrapper > div > div.catalog-menu > ul > li:nth-child(3) > a")
    public WebElement SaleLink;

    @FindBy(xpath ="//*[@class=\'product-readmore\']//a")
    List<WebElement> elements;

    public SalePage (WebDriver browser) {
        this.driver = browser;
        this.driver.manage().window().fullscreen();
        PageFactory.initElements(browser, this);


    }

    public void Navigate(String Pageurl)
    {
        this.driver.navigate().to(this.url);
    }

    public String GetSaleLink()
    {
       return SaleLink.getAttribute("href");
    }

    public String[] GetOneProductSaleLink(int count)
    {

        String[] Links = new String[count];
        for (int i=0; i < count; i++) {
            Random rand = new Random();
            WebElement randomElement = elements.get(rand.nextInt(elements.size()));
           // System.out.println(randomElement.getAttribute("href"));
            Links[i] = (randomElement.getAttribute("href"));

        }

        return Links;
    }
}

