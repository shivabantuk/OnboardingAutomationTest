package SeleniumWebdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task3_3 {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/infinite_scroll");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for(int i=1;i<=10;i++){
            js.executeScript("window.scrollBy(0,500)");
            Thread.sleep(2000);
           System.out.println( driver.findElement(By.xpath("(//div[@class='jscroll-added'])["+i+"]")).getText());
           System.out.println(" ");
        }
    }
}
