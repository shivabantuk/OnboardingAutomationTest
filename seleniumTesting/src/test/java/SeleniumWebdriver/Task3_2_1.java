package SeleniumWebdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Task3_2_1 {
    @Test
    public void Edge(){
        System.setProperty("webdriver.edge.driver","C:\\Users\\ShivaKumarBantu\\Downloads\\edgedriver_win64 (1)\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("tomsmith");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        String text = driver.findElement(By.xpath("//h4[@class='subheader']")).getText();
        System.out.println(text);
    }
}
