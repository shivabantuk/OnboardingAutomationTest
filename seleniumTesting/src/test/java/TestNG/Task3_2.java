package TestNG;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Task3_2 {

    @Test(dataProvider = "loginData")
    public void loginfunctionality(HashMap<String, String> input) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys(input.get("username"));
        driver.findElement(By.id("password")).sendKeys(input.get("password"));
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);
        System.out.println( driver.findElement(By.xpath("//h4[@class='subheader']")).getText());
    }

    @DataProvider(name = "loginData")
    public Object[][] data() throws IOException {
        File fileReader = new File("C:\\Users\\ShivaKumarBantu\\IdeaProjects\\pizzashops\\seleniumTesting\\src\\test\\java\\TestNG\\inputdata.json");
        String jsondata = FileUtils.readFileToString(fileReader);
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(jsondata, new TypeReference<List<HashMap<String, String>>>() {});
        return new Object[][] {{data.get(0)},{data.get(1)}};



    }
    }

