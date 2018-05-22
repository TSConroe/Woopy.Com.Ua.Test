package pac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;




public class BoysPage  {

    private WebDriver driver;
    String url = "https://www.woopy.com.ua";

    @FindBy(css ="#wrapper > div > div.catalog-menu > ul > li:nth-child(1) > a")
    public WebElement GirlsLink;

    @FindBy(xpath ="//*[@id=\"main\"]//div[3]/a")
    public WebElement ClearFilter;

    @FindBy(xpath ="//*[@name=\"category_19\"]")
    public WebElement ShoesCheckBox;

    @FindBy(css ="#main > div.content > div.category-view > div.more-link-prod > form > a\n")
    public WebElement ShowMoreButton;
    @FindBy(xpath ="//*[@class=\"product-title\"]//a[1]")
    public List<WebElement> productName;

    public List<WebElement> orederNumber;

    public BoysPage (WebDriver browser) {
        this.driver = browser;
        //  this.driver.manage().window().fullscreen();
        PageFactory.initElements(browser, this);


    }

    public void Navigate(String Pageurl)
    {
        this.driver.navigate().to(this.url);
    }


    public void ClearFilter()
    {
        ClearFilter.click();
    }

    public void СhoiceFootwearType()
    {
        ShoesCheckBox.click();
        ShoesCheckBox.submit();

    }

    public void OpenAllProduct()
    {
        productName = driver.findElements(By.xpath("//*[@class=\"product-title\"]//a[1]"));
        orederNumber =driver.findElements(By.xpath("//*[@class=\"order-number\"]//span"));

        for (int i = 0; i< productName.size(); i++
                ) {
          //  System.out.println(productName.get(i).getText());
            if (!"КРОССОВКИ".equalsIgnoreCase(productName.get(i).getText()))

                System.out.println(productName.get(i).getText() + "" + orederNumber.get(i).getText());


            }
        }
      /*  while (ShowMoreButton.isDisplayed()) {
              productName = driver.findElements(By.xpath("//*[@class=\"product-title\"]//a[1]"));
            for (WebElement w: productName
                    ) {
                System.out.println(w.getText());

                ShowMoreButton.click();
}
            }*/

        }






