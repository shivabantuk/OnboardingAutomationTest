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
        // Set up ChromeDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(testName = "TC001_ValidRegistration")
    public void testValidRegistration() {
        driver.get(URL);

        // Fill in the form
        driver.findElement(By.id("firstname")).sendKeys("John");
        driver.findElement(By.id("lastname")).sendKeys("Doe");
        driver.findElement(By.id("username")).sendKeys("johndoe123");
        driver.findElement(By.id("password")).sendKeys("Password123!");

        // Submit the form
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Assert successful registration
        WebElement successMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-success')]");
        Assert.assertTrue(successMessage.isDisplayed(), "Success message should be displayed");
        Assert.assertEquals(successMessage.getText(), "Registration successful!", "Incorrect success message");
    }

    @Test(testName = "TC002_EmptyFields")
    public void testEmptyFields() {
        driver.get(URL);

        // Submit the form without filling any fields
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Assert error messages for all fields
        Assert.assertTrue(driver.findElement(By.id("firstname-error")).isDisplayed(), "First name error should be displayed");
        Assert.assertTrue(driver.findElement(By.id("lastname-error")).isDisplayed(), "Last name error should be displayed");
        Assert.assertTrue(driver.findElement(By.id("username-error")).isDisplayed(), "Username error should be displayed");
        Assert.assertTrue(driver.findElement(By.id("password-error")).isDisplayed(), "Password error should be displayed");
    }

    @Test(testName = "TC003_InvalidUsername")
    public void testInvalidUsername() {
        driver.get(URL);

        // Fill in the form with an invalid username (too short)
        driver.findElement(By.id("firstname")).sendKeys("Jane");
        driver.findElement(By.id("lastname")).sendKeys("Smith");
        driver.findElement(By.id("username")).sendKeys("js");
        driver.findElement(By.id("password")).sendKeys("Password123!");

        // Submit the form
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Assert error message for username
        WebElement usernameError = driver.findElement(By.id("username-error"));
        Assert.assertTrue(usernameError.isDisplayed(), "Username error should be displayed");
        Assert.assertEquals(usernameError.getText(), "Please enter at least 3 characters.", "Incorrect username error message");
    }

    @Test(testName = "TC004_WeakPassword")
    public void testWeakPassword() {
        driver.get(URL);

        // Fill in the form with a weak password
        driver.findElement(By.id("firstname")).sendKeys("Alice");
        driver.findElement(By.id("lastname")).sendKeys("Johnson");
        driver.findElement(By.id("username")).sendKeys("alicejohnson");
        driver.findElement(By.id("password")).sendKeys("12345");

        // Submit the form
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Assert error message for