package pac.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;


public class GirlsPage {

    private WebDriver driver;
    String url = "https://www.woopy.com.ua";

    @FindBy(css = "#wrapper > div > div.catalog-menu > ul > li:nth-child(2) > a")
    public WebElement GirlsLink;

    @FindBy(xpath = "//*[@id=\"main\"]//div[3]/a")
    public WebElement ClearFilter;

    @FindBy(css = "#form_function > div > div:nth-child(3) > div:nth-child(6) > label > div")
    public WebElement ShoesCheckBox;

    @FindBy(css = "#main > div.content > div.category-view > div.more-link-prod > form > a")
    public WebElement ShowMoreButton;



    List<WebElement> productPrices;

    public GirlsPage(WebDriver browser) {
        this.driver = browser;
        //  this.driver.manage().window().fullscreen();
        PageFactory.initElements(browser, this);


    }

    public void Navigate() {
        this.driver.navigate().to(this.url);
    }


    public void ChoiceFootwearType() {

        //Clear
        ClearFilter.click();
        //Choice
        ShoesCheckBox.click();
        ShoesCheckBox.submit();

    }
    public void NexPage() {
        ShowMoreButton.click();

    }


    public int GetPageCount() {

        List <WebElement> pageCount= driver.findElements(By.xpath("//*[@class=\"page-nav\"]//li"));
        int count = pageCount.size();
        return count;
    }

    public List<String> OpenAllProduct() {
        productPrices = driver.findElements(By.xpath("//*[@class=\"product-price\"]"));


        List <String> LinkList = new ArrayList<>();

        for (int i = 0; i < productPrices.size(); i++)
        {
            LinkList.add(productPrices.get(i).getText());

        }
        return LinkList;
        }

    }









