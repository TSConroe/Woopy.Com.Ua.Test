package pac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;
import java.util.Random;





public class GirlsPage {

    private WebDriver driver;
    String url = "https://www.woopy.com.ua";

    @FindBy(css = "#wrapper > div > div.catalog-menu > ul > li:nth-child(2) > a")
    public WebElement GirlsLink;

    @FindBy(xpath = "//*[@id=\"main\"]//div[3]/a")
    public WebElement ClearFilter;

    @FindBy(xpath = "//*[@name=\"category_19\"]")
    public WebElement ShoesCheckBox;

    @FindBy(css = "#main > div.content > div.category-view > div.more-link-prod > form > a\n")
    public WebElement ShowMoreButton;

    List<WebElement> productPrices;

    public GirlsPage(WebDriver browser) {
        this.driver = browser;
        //  this.driver.manage().window().fullscreen();
        PageFactory.initElements(browser, this);


    }

    public void Navigate(String Pageurl) {
        this.driver.navigate().to(this.url);
    }


    public void ClearFilter() {
        ClearFilter.click();
    }

    public void СhoiceFootwearType() {
        ShoesCheckBox.click();
        ShoesCheckBox.submit();

    }

    public boolean OpenAllProduct() {
        while (ShowMoreButton.isDisplayed()) {

            productPrices = driver.findElements(By.xpath("//*[@class=\"product-price\"]"));
            for (WebElement w : productPrices
                    ) {
                System.out.println(w.getText().isEmpty());
                if (w.getText().isEmpty()) ;
                return false;


                //  System.out.print(w.getText().matches("[0-9]"));

            }
            ShowMoreButton.click();


        }
        return true;
    }
}





