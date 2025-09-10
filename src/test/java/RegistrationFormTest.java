import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationFormTest {

    private WebDriver driver;
    private static final String URL = "https://www.tutorialspoint.com/selenium/practice/register.php";

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(testName = "TC001_ValidRegistration")
    public void testValidRegistration() {
        WebElement firstName = driver.findElement(By.id("first-name"));
        WebElement lastName = driver.findElement(By.id("last-name"));
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));

        firstName.sendKeys("John");
        lastName.sendKeys("Doe");
        username.sendKeys("johndoe");
        password.sendKeys("password123");
        submitButton.click();

        WebElement successMessage = driver.findElement(By.cssSelector(".alert-success"));
        Assert.assertTrue(successMessage.isDisplayed(), "Success message should be displayed");
        Assert.assertEquals(successMessage.getText(), "Registration successful!", "Incorrect success message");
    }

    @Test(testName = "TC002_EmptyFields")
    public void testEmptyFields() {
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();

        WebElement firstNameError = driver.findElement(By.id("first-name-error"));
        WebElement lastNameError = driver.findElement(By.id("last-name-error"));
        WebElement usernameError = driver.findElement(By.id("username-error"));
        WebElement passwordError = driver.findElement(By.id("password-error"));

        Assert.assertTrue(firstNameError.isDisplayed(), "First name error should be displayed");
        Assert.assertTrue(lastNameError.isDisplayed(), "Last name error should be displayed");
        Assert.assertTrue(usernameError.isDisplayed(), "Username error should be displayed");
        Assert.assertTrue(passwordError.isDisplayed(), "Password error should be displayed");
    }

    @Test(testName = "TC003_InvalidUsername")
    public void testInvalidUsername() {
        WebElement firstName = driver.findElement(By.id("first-name"));
        WebElement lastName = driver.findElement(By.id("last-name"));
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));

        firstName.sendKeys("Jane");
        lastName.sendKeys("Smith");
        username.sendKeys("jane@smith"); // Invalid username with special characters
        password.sendKeys("password456");
        submitButton.click();

        WebElement usernameError = driver.findElement(By.id("username-error"));
        Assert.assertTrue(usernameError.isDisplayed(), "Username error should be displayed");
    }
}
