package pac;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class MainPage  {

    private  WebDriver driver;
    String url = "https://www.woopy.com.ua";

    public MainPage (WebDriver browser) {
        this.driver = browser;
        this.driver.manage().window().fullscreen();
        PageFactory.initElements(browser, this);


    }

    public void Navigate()
    {
        this.driver.navigate().to(this.url);
    }
}

