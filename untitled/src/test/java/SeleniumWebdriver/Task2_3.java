package SeleniumWebdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Task2_3 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/alerts#google_vignette");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        driver.findElement(By.id("alertButton")).click();
        String s = driver.switchTo().alert().getText();
        Assert.assertEquals(s, "You clicked a button");
        driver.switchTo().alert().accept();
        driver.findElement(By.id("timerAlertButton")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.alertIsPresent());
        String ss = driver.switchTo().alert().getText();
        Assert.assertEquals(ss, "This alert appeared after 5 seconds");
        driver.switchTo().alert().accept();
        driver.findElement(By.id("confirmButton")).click();
        driver.switchTo().alert().dismiss();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.xpath("((//div[@class='col-md-6'])[3]/*)[2]")).getText());
        driver.findElement(By.id("promtButton")).click();
        driver.switchTo().alert().sendKeys("shiva");
        driver.switchTo().alert().accept();
        //promptResult
        System.out.println(driver.findElement(By.xpath("((//div[@class='col-md-6'])[4]/*)[2]")).getText());



    }
}
