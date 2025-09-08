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
    private String baseUrl = "https://www.tutorialspoint.com/selenium/practice/register.php";

    @BeforeClass
    public void setUp() {
        // Set up ChromeDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void testSuccessfulRegistration() {
        driver.get(baseUrl);

        // Fill in the registration form
        driver.findElement(By.id("firstname")).sendKeys("John");
        driver.findElement(By.id("lastname")).sendKeys("Doe");
        driver.findElement(By.id("username")).sendKeys("johndoe123");
        driver.findElement(By.id("password")).sendKeys("Password123!");

        // Submit the form
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Verify successful registration
        WebElement successMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-success')]"));
        Assert.assertTrue(successMessage.isDisplayed(), "Success message not displayed");
        Assert.assertEquals(successMessage.getText(), "Registration successful!", "Incorrect success message");
    }

    @Test(priority = 2)
    public void testEmptyFields() {
        driver.get(baseUrl);

        // Submit the form without filling any fields
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Verify error messages for all fields
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(), 'First name is required')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(), 'Last name is required')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(), 'Username is required')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(), 'Password is required')]")).isDisplayed());
    }

    @Test(priority = 3)
    public void testInvalidUsername() {
        driver.get(baseUrl);

        // Fill in the registration form with an invalid username (too short)
        driver.findElement(By.id("firstname")).sendKeys("Jane");
        driver.findElement(By.id("lastname")).sendKeys("Smith");
        driver.findElement(By.id("username")).sendKeys("ja");
        driver.findElement(By.id("password")).sendKeys("Password123!");

        // Submit the form
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Verify error message for invalid username
        WebElement usernameError = driver.findElement(By.xpath("//div[contains(text(), 'Username must be at least 3 characters')]"));
        Assert.assertTrue(usernameError.isDisplayed(), "Username error message not displayed");
    }

    @Test(priority = 4)
    public void testInvalidPassword() {
        driver.get(baseUrl);

        // Fill in the registration form with an invalid password (too short)
        driver.findElement(By.id("firstname")).sendKeys("Alice");
        driver.findElement(By.id("lastname")).sendKeys("Johnson");
        driver.findElement(By.id("username")).sendKeys("alice_j");
        driver.findElement(By.id("password")).sendKeys("pass");
    }
}
