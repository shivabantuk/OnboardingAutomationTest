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
    private final String URL = "https://www.tutorialspoint.com/selenium/practice/register.php";

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
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        WebElement successMessage = driver.findElement(By.cssSelector(".alert-success"));
        Assert.assertTrue(successMessage.isDisplayed(), "Success message should be displayed");
        Assert.assertEquals(successMessage.getText(), "Registration successful!", "Incorrect success message");
    }

    @Test(testName = "TC002_EmptyFields")
    public void testEmptyFields() {
        driver.get(URL);

        driver.findElement(By.cssSelector("button[type='submit']")).click();

        WebElement firstNameError = driver.findElement(By.id("firstname-error"));
        WebElement lastNameError = driver.findElement(By.id("lastname-error"));
        WebElement usernameError = driver.findElement(By.id("username-error"));
        WebElement passwordError = driver.findElement(By.id("password-error"));

        Assert.assertTrue(firstNameError.isDisplayed(), "First name error should be displayed");
        Assert.assertTrue(lastNameError.isDisplayed(), "Last name error should be displayed");
        Assert.assertTrue(usernameError.isDisplayed(), "Username error should be displayed");
        Assert.assertTrue(passwordError.isDisplayed(), "Password error should be displayed");
    }

    @Test(testName = "TC003_InvalidUsername")
    public void testInvalidUsername() {
        driver.get(URL);

        driver.findElement(By.id("firstname")).sendKeys("Jane");
        driver.findElement(By.id("lastname")).sendKeys("Smith");
        driver.findElement(By.id("username")).sendKeys("jane@smith");
        driver.findElement(By.id("password")).sendKeys("password123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        WebElement usernameError = driver.findElement(By.id("username-error"));
        Assert.assertTrue(usernameError.isDisplayed(), "Username error should be displayed");
        Assert.assertEquals(usernameError.getText(), "Please enter a valid username", "Incorrect username error message");
    }

    @Test(testName = "TC004_WeakPassword")
    public void testWeakPassword() {
        driver.get(URL);

        driver.findElement(By.id("firstname")).sendKeys("Alice");
        driver.findElement(By.id("lastname")).sendKeys("Johnson");
        driver.findElement(By.id("username")).sendKeys("alicejohnson");
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        WebElement passwordError = driver.findElement(By.id("password-error"));
        Assert.assertTrue(passwordError.isDisplayed(), "Password error should be displayed");
        Assert.assertEquals(passwordError.getText(), "Password is too weak", "Incorrect password error message");
    }
}
