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

    @Test(testName = "TC001_SuccessfulRegistration")
    public void testSuccessfulRegistration() {
        WebElement firstName = driver.findElement(By.id("firstname"));
        WebElement lastName = driver.findElement(By.id("lastname"));
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));

        firstName.sendKeys("John");
        lastName.sendKeys("Doe");
        username.sendKeys("johndoe");
        password.sendKeys("password123");
        submitButton.click();

        WebElement successMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-success')]");
        Assert.assertTrue(successMessage.isDisplayed(), "Success message should be displayed");
        Assert.assertEquals(successMessage.getText(), "User Registered Successfully.", "Incorrect success message");
    }

    @Test(testName = "TC002_EmptyFieldsValidation")
    public void testEmptyFieldsValidation() {
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();

        WebElement firstNameError = driver.findElement(By.id("firstname_error"));
        WebElement lastNameError = driver.findElement(By.id("lastname_error"));
        WebElement usernameError = driver.findElement(By.id("username_error"));
        WebElement passwordError = driver.findElement(By.id("password_error"));

        Assert.assertTrue(firstNameError.isDisplayed(), "First name error should be displayed");
        Assert.assertTrue(lastNameError.isDisplayed(), "Last name error should be displayed");
        Assert.assertTrue(usernameError.isDisplayed(), "Username error should be displayed");
        Assert.assertTrue(passwordError.isDisplayed(), "Password error should be displayed");
    }

    @Test(testName = "TC003_InvalidUsernameFormat")
    public void testInvalidUsernameFormat() {
        WebElement firstName = driver.findElement(By.id("firstname"));
        WebElement lastName = driver.findElement(By.id("lastname"));
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));

        firstName.sendKeys("John");
        lastName.sendKeys("Doe");
        username.sendKeys("john@doe"); // Invalid username with special character
        password.sendKeys("password123");
        submitButton.click();

        WebElement usernameError = driver.findElement(By.id("username_error"));
        Assert.assertTrue(usernameError.isDisplayed(), "Username error should be displayed");
        Assert.assertEquals(usernameError.getText(), "Username should contain only letters and numbers", "Incorrect username error message");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}