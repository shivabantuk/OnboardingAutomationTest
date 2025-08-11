package SeleniumWebdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Task3_2 {
    @Test
    public void chrome(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("tomsmith");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        String text = driver.findElement(By.xpath("//h4[@class='subheader']")).getText();
        System.out.println(text);
    }
}
