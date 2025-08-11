package SeleniumWebdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;

public class Task1_2 {
    public static void main(String[] args) throws InterruptedException {

        String pic = "C:\\Users\\ShivaKumarBantu\\Downloads\\pic.jpg";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)");

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("currentAddress"))).build().perform();
        driver.findElement(By.id("firstName")).sendKeys("shiva");
        driver.findElement(By.id("lastName")).sendKeys("kumar");
        driver.findElement(By.id("userEmail")).sendKeys("shiva@gmail.com");
        driver.findElement(By.xpath("//label[@for = 'gender-radio-1']")).click();
        driver.findElement(By.id("userNumber")).sendKeys("1234567890");
        driver.findElement(By.id("dateOfBirthInput")).click();
        WebElement year = driver.findElement(By.xpath("//*[@class='react-datepicker__year-select']"));
        Select selectyear = new Select(year);
        selectyear.selectByValue("1999");
        Thread.sleep(2000);
        WebElement month = driver.findElement(By.xpath("//*[@class='react-datepicker__month-select']"));
        Select selectmonth = new Select(month);
        selectmonth.selectByValue("2");
        Thread.sleep(2000);
        //*[@class='react-datepicker__week']/div[contains(@class,"react-datepicker__day")]
        List<WebElement> date = driver.findElements(By.xpath("//*[@class='react-datepicker__week']/div[contains(@class,'react-datepicker__day')]"));
        for (WebElement element : date) {
            if (element.getText().equals("23")) {
                element.click();
                break;
            }
        }
        ////div[contains(@id,'subjectsContainer')]/div[@class='subjects-auto-complete__control css-yk16xz-control']/div/div
        WebElement subject = driver.findElement(By.xpath("//input[@id='subjectsInput']"));
        actions.moveToElement(subject).sendKeys("english").build().perform();
        driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']")).click();
        driver.findElement(By.id("uploadPicture")).sendKeys(pic);
        driver.findElement(By.id("currentAddress")).sendKeys("1-6-2-34, hyderabad");
        js.executeScript("window.scrollBy(0,250)");
        WebElement selectstate = driver.findElement(By.xpath("(//div[@class=' css-tlfecz-indicatorContainer'])[1]"));
        actions.click(selectstate).sendKeys(Keys.ARROW_DOWN).click().build().perform();
        driver.findElement(By.id("submit")).submit();
        System.out.println(driver.findElement(By.id("example-modal-sizes-title-lg")).getText());


    }


}

