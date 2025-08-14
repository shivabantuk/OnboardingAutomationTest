package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task2_2 {
    WebDriver driver;

    @BeforeTest
    public void beforeTest(){
         driver=new ChromeDriver();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void validatetitle(){
        driver.get("https://the-internet.herokuapp.com/login");
        Assert.assertEquals(driver.getTitle(), "The Internet");
    }
    @Test(priority = 2)
    public void login() throws InterruptedException {
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);
       System.out.println( driver.findElement(By.xpath("//h4[@class='subheader']")).getText());
        Assert.assertEquals(driver.findElement(By.xpath("//h4[@class='subheader']")).getText(), "Welcome to the Secure Area. When you are done click logout below.");
    }
}
