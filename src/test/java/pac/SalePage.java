package pac;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;


public class SalePage {

    private WebDriver driver;
    String url = "https://www.woopy.com.ua/index.php/component/virtuemart/view/category/virtuemart_category_id/8";


    @FindBy(className = "old-price")
    public WebElement oldPrice;

    @FindBy(xpath = "//*[@class=\'product-readmore\']//a")
    List<WebElement> elements;

    public SalePage(WebDriver browser) {
        this.driver = browser;
        this.driver.manage().window().fullscreen();
        PageFactory.initElements(driver, this);


    }

    public void Navigate() {
        this.driver.navigate().to(this.url);
    }


    public String[] GetOneProductSaleLink(int count) {

        String[] Links = new String[count];
        for (int i = 0; i < count; i++) {
            Random rand = new Random();
            WebElement randomElement = elements.get(rand.nextInt(elements.size()));
                Links[i] = (randomElement.getAttribute("href"));

        }

        return Links;



    }
    public WebElement GetOldPrice ()
    {
        return oldPrice;

    }
}