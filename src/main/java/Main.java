import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.setProperty("webdriver.chrome.driver", "C://Chromedriver//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.woopy.com.ua/");
       //string Title = driver.getTitle();

                }
    }
class SumTwoDigit{

    public int GetSum(int a, int b){

        return a+b;
    }
}

