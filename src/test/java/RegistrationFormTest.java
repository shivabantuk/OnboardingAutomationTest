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

    @Test(priority = 1)
    public void testSuccessfulRegistration() {
        driver.get(URL);

        // Fill in the form
        driver.findElement(By.id("firstname")).sendKeys("John");
        driver.findElement(By.id("lastname")).sendKeys("Doe");
        driver.findElement(By.id("username")).sendKeys("johndoe");
        driver.findElement(By.id("password")).sendKeys("password123");

        // Submit the form
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Verify successful registration
        WebElement successMessage = driver.findElement(By.cssSelector(".alert-success"));
        Assert.assertTrue(successMessage.isDisplayed(), "Success message should be displayed");
        Assert.assertEquals(successMessage.getText(), "User registered successfully", "Incorrect success message");
    }

    @Test(priority = 2)
    public void testEmptyFields() {
        driver.get(URL);

        // Submit the form without filling any fields
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Verify error messages
        Assert.assertTrue(driver.findElement(By.id("firstname-error")).isDisplayed(), "First name error should be displayed");
        Assert.assertTrue(driver.findElement(By.id("lastname-error")).isDisplayed(), "Last name error should be displayed");
        Assert.assertTrue(driver.findElement(By.id("username-error")).isDisplayed(), "Username error should be displayed");
        Assert.assertTrue(driver.findElement(By.id("password-error")).isDisplayed(), "Password error should be displayed");
    }

    @Test(priority = 3)
    public void testInvalidUsername() {
        driver.get(URL);

        // Fill in the form with an invalid username (less than 6 characters)
        driver.findElement(By.id("firstname")).sendKeys("Jane");
        driver.findElement(By.id("lastname")).sendKeys("Smith");
        driver.findElement(By.id("username")).sendKeys("jane");
        driver.findElement(By.id("password")).sendKeys("password123");

        // Submit the form
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Verify error message for username
        WebElement usernameError = driver.findElement(By.id("username-error"));
        Assert.assertTrue(usernameError.isDisplayed(), "Username error should be displayed");
        Assert.assertEquals(usernameError.getText(), "Please enter at least 6 characters.", "Incorrect username error message");
    }

    @Test(priority = 4)
    public void testInvalidPassword() {
        driver.get(URL);

        // Fill in the form with an invalid password (less than 8 characters)
        driver.findElement(By.id("firstname")).sendKeys("Alice");
        driver.findElement(By.id("lastname")).sendKeys("Johnson");
        driver.findElement(By.id("username")).sendKeys("alicejohnson");
        driver.findElement(By.id("password")).sendKeys("pass");

        // Submit the form
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Verify error message for password
        WebElement passwordError = driver.findElement(By.id("password-error"));
        Assert.assertTrue(passwordError.isDisplayed(), "Password error should be displayed");
        Assert.assertEquals(passwordError.getText(), "Please enter at least 8 characters.", "Incorrect password error message");
    }

    @AfterClass
