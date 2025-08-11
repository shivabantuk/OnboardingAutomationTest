package SeleniumWebdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Task2_1 {
    public WebDriver driver;

    @Test(priority = 1)
    public void task2() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.seleniumeasy.com/lander");
    }

    @Test(priority = 2, retryAnalyzer = retry.class)
    public void task2step2() throws InterruptedException {
        //a[contains(@href,'https://www.seleniumeasy.com/lander?query=Selenium+Testing')]
        driver.navigate().refresh();
        WebElement iframe = driver.findElement(By.xpath("//div[@id='relatedLinks']/iframe"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//a[contains(@href,'https://www.seleniumeasy.com/lander?query=Selenium+Testing')]")).click();
    }

    @Test(dependsOnMethods = "task2step2", priority = 3, retryAnalyzer = retry.class)
    public void task2step3() throws InterruptedException {
        driver.navigate().refresh();
        WebElement iframe2 = driver.findElement(By.xpath("(//iframe)[3]"));
        driver.switchTo().frame(iframe2);
        Thread.sleep(2000);
        List<WebElement> URLS = driver.findElements(By.xpath("//a[@class='p_ si27 a']"));
        for (WebElement url : URLS) {
            String openInNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
            url.sendKeys(openInNewTab);
        }
        Set<String> s = driver.getWindowHandles();
        Iterator<String> it = s.iterator();
        String currentWindow = driver.getWindowHandle();
        while (it.hasNext()) {
            driver.switchTo().window(it.next());
            System.out.println("Title: " + driver.getTitle());
            System.out.println("URL: " + driver.getCurrentUrl());
        }
        driver.switchTo().window(currentWindow);
        driver.switchTo().frame(iframe2);
        driver.findElement(By.xpath("(//a[@class='p_ si27 a'])[2]")).click();

    }
}
