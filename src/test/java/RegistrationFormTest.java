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

        WebElement firstNameField = driver.findElement(By.id("firstname"));
        WebElement lastNameField = driver.findElement(By.id("lastname"));
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));

        firstNameField.sendKeys("John");
        lastNameField.sendKeys("Doe");
        usernameField.sendKeys("johndoe");
        passwordField.sendKeys("password123");
        submitButton.click();

        WebElement successMessage = driver.findElement(By.cssSelector(".alert-success"));
        Assert.assertTrue(successMessage.isDisplayed(), "Success message not displayed");
        Assert.assertEquals(successMessage.getText(), "Registration successful", "Incorrect success message");
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

        Assert.assertTrue(firstNameError.isDisplayed(), "First name error not displayed");
        Assert.assertTrue(lastNameError.isDisplayed(), "Last name error not displayed");
        Assert.assertTrue(usernameError.isDisplayed(), "Username error not displayed");
        Assert.assertTrue(passwordError.isDisplayed(), "Password error not displayed");
    }

    @Test(priority = 3)
    public void testInvalidUsername() {
        driver.get(URL);

        WebElement firstNameField = driver.findElement(By.id("firstname"));
        WebElement lastNameField = driver.findElement(By.id("lastname"));
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));

        firstNameField.sendKeys("Jane");
        lastNameField.sendKeys("Smith");
        usernameField.sendKeys("jane@smith");  // Invalid username with special character
        passwordField.sendKeys("password123");
        submitButton.click();

        WebElement usernameError = driver.findElement(By.id("username-error"));
        Assert.assertTrue(usernameError.isDisplayed(), "Username error not displayed");
        Assert.assertEquals(usernameError.getText(), "Please enter a valid username", "Incorrect username error message");
    }

    @Test(priority = 4)
    public void testWeakPassword() {
        driver.get(URL); create a pull request targeting a main branch with the Certainly! I'll provide you with a Java + Selenium WebDriver + TestNG automated test script for the Registration Form on the given URL. This script will include both functional and negative test cases, along with setup and teardown methods.

Here's the complete script:

```java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations