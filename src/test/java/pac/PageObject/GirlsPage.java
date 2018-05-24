package pac.PageObject;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;


public class GirlsPage {

    private WebDriver driver;
    String url = "https://www.woopy.com.ua";


    @FindBy(xpath = "//*[@id=\"main\"]//div[3]/a")
    public WebElement ClearFilter;

    @FindBy(css = "#form_function > div > div:nth-child(3) > div:nth-child(6) > label > div")
    public WebElement ShoesCheckBox;

    @FindBy(css = "#main > div.content > div.category-view > div.more-link-prod > form > a")
    public WebElement ShowMoreButton;


    @FindBy(xpath = "//*[@class=\"product-price\"]")
    List<WebElement> productPrices;

    @FindBy(xpath = "//*[@class=\"page-nav\"]//li")
    List<WebElement> pageCount;


    public GirlsPage(WebDriver browser) {

        this.driver = browser;
        this.driver.manage().window().maximize();
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

        int count = pageCount.size();
        return count;
    }

    public List<String> OpenAllProduct() {


        List<String> LinkList = new ArrayList<>();

        for (int i = 0; i < productPrices.size(); i++) {
            LinkList.add(productPrices.get(i).getText());

        }
        try {

            ShowMoreButton.click();

        } catch (NoSuchElementException e) {

    /*      (ShowMoreButton.isDisplayed()) - cant stop if-cycle
            So I use try catch
            Because there are elements in last page which I need to check also

     */
        }
        return LinkList;
    }

}









