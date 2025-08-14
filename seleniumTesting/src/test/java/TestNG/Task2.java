package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task2 {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod(){
         driver=new ChromeDriver();
    }

    @Test
    public void openGoogle(){
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
    }
    @Test
    public void verifypageLoad(){
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        if (title.equals("Google")) {
            System.out.println("Page loaded successfully");
        } else {
            System.out.println("Page did not load successfully");
        }

    }
    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }
}
