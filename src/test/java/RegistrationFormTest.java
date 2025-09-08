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

    @Test(priority = 1)
    public void testSuccessfulRegistration() {
        driver.get(URL);

        WebElement firstName = driver.findElement(By.id("firstname"));
        WebElement lastName = driver.findElement(By.id("lastname"));
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));

        firstName.sendKeys("John");
        lastName.sendKeys("Doe");
        username.sendKeys("johndoe");
        password.sendKeys("password123");
        submitButton.click();

        WebElement successMessage = driver.findElement(By.cssSelector(".alert-success"));
        Assert.assertTrue(successMessage.isDisplayed(), "Success message should be displayed");
        Assert.assertEquals(successMessage.getText(), "User Registered Successfully.", "Incorrect success message");
    }

    @Test(priority = 2)
    public void testEmptyFields() {
        driver.get(URL);

        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();

        WebElement firstNameError = driver.findElement(By.id("firstname-error"));
        WebElement lastNameError = driver.findElement(By.id("lastname-error"));
        WebElement usernameError = driver.findElement(By.id("username-error"));
        WebElement passwordError = driver.findElement(By.id("password-error"));

        Assert.assertTrue(firstNameError.isDisplayed(), "First name error should be displayed");
        Assert.assertTrue(lastNameError.isDisplayed(), "Last name error should be displayed");
        Assert.assertTrue(usernameError.isDisplayed(), "Username error should be displayed");
        Assert.assertTrue(passwordError.isDisplayed(), "Password error should be displayed");
    }

    @Test(priority = 3)
    public void testInvalidUsername() {
        driver.get(URL);

        WebElement firstName = driver.findElement(By.id("firstname"));
        WebElement lastName = driver.findElement(By.id("lastname"));
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));

        firstName.sendKeys("Jane");
        lastName.sendKeys("Smith");
        username.sendKeys("jane@smith");  // Invalid username with special character
        password.sendKeys("password456");
        submitButton.click();

        WebElement usernameError = driver.findElement(By.id("username-error"));
        Assert.assertTrue(usernameError.isDisplayed(), "Username error should be displayed");
        Assert.assertEquals(usernameError.getText(), "Please enter a valid username", "Incorrect username error message");
    }

    @Test(priority = 4)
    public void testShortPassword() {
        driver.get(URL);

        WebElement firstName = driver.findElement(By.id("firstname"));
        WebElement lastName = driver.findElement(By.id("lastname"));
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));

        firstName.sendKeys("Tom");
        lastName.sendKeys("Hanks");
        username.send