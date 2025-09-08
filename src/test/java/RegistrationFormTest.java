import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegistrationFormTest {

    private WebDriver driver;
    private static final String URL = "https://www.tutorialspoint.com/selenium/practice/register.php";

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(testName = "TC001_ValidRegistration")
    public void testValidRegistration() {
        driver.get(URL);

        driver.findElement(By.id("firstname")).sendKeys("John");
        driver.findElement(By.id("lastname")).sendKeys("Doe");
        driver.findElement(By.id("username")).sendKeys("johndoe");
        driver.findElement(By.id("password")).sendKeys("password123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebElement successMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-success')]"));
        Assert.assertTrue(successMessage.isDisplayed(), "Success message should be displayed");
        Assert.assertEquals(successMessage.getText(), "Registration successful!", "Incorrect success message");
    }

    @Test(testName = "TC002_EmptyFields")
    public void testEmptyFields() {
        driver.get(URL);

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebElement errorMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message should be displayed");
        Assert.assertEquals(errorMessage.getText(), "Please fill in all fields!", "Incorrect error message");
    }

    @Test(testName = "TC003_InvalidUsername")
    public void testInvalidUsername() {
        driver.get(URL);

        driver.findElement(By.id("firstname")).sendKeys("Jane");
        driver.findElement(By.id("lastname")).sendKeys("Smith");
        driver.findElement(By.id("username")).sendKeys("jane@smith");
        driver.findElement(By.id("password")).sendKeys("password456");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebElement errorMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message should be displayed");
        Assert.assertEquals(errorMessage.getText(), "Invalid username format!", "Incorrect error message");
    }

    @Test(testName = "TC004_WeakPassword")
    public void testWeakPassword() {
        driver.get(URL);

        driver.findElement(By.id("firstname")).sendKeys("Alice");
        driver.findElement(By.id("lastname")).sendKeys("Johnson");
        driver.findElement(By.id("username")).sendKeys("alicejohnson");
        driver.findElement(By.id("password")).sendKeys("weak");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebElement errorMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message should be displayed");
        Assert.assertEquals(errorMessage.getText(), "Weak password!", "Incorrect error message");
    }
}
