package SeleniumWebdriver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class task3_1 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://books-pwakit.appspot.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement shadowRoot = (WebElement) js.executeScript("return document.querySelector('book-app')");
        WebElement searchInput = (WebElement) js.executeScript("return argument[0].querySelector('input#input')", shadowRoot);
        searchInput.sendKeys("selenium");
        searchInput.sendKeys(Keys.ENTER);
        WebElement result  = (WebElement) js.executeScript("return argument[0].querySelector('').shadowRoot.querySelector('div#results')", shadowRoot);
        System.out.println(result.getText());
    }
}
