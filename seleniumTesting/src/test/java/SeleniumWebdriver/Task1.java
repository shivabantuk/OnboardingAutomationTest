package SeleniumWebdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Task1 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();



/*

        HashMap<String, Object> chromepref = new HashMap<String, Object>();
        chromepref.put("credentials_enable_service", false);
        chromepref.put("profile.password_manager_enabled", false);
        chromepref.put("profile.password_manager_leak_detedtion", false);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromepref);
        options.setCapability(ChromeOptions.CAPABILITY, options); */
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");


        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("tomsmith");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        String text = driver.findElement(By.xpath("//h4[@class='subheader']")).getText();
        String[] s = text.split("When");
        String welcometext = s[0];
        System.out.println(welcometext);
        driver.findElement(By.xpath("//i[text()=' Logout']")).click();
        System.out.println(driver.findElement(By.id("flash")).getText());
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("shiva");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("SuperSecretPassword");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        System.out.println(driver.findElement(By.id("flash")).getText());


    }
}
