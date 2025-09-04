import unittest
from selenium import webdriver
from selenium.webdriver.common.by import By

class RegistrationFormTests(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Chrome()
        self.driver.get("http://example.com/register")

    def tearDown(self):
        self.driver.quit()

    def test_valid_registration(self):
        driver = self.driver
        driver.find_element(By.NAME, "username").send_keys("testuser")
        driver.find_element(By.NAME, "email").send_keys("testuser@example.com")
        driver.find_element(By.NAME, "password").send_keys("password123")
        driver.find_element(By.NAME, "confirm_password").send_keys("password123")
        driver.find_element(By.NAME, "submit").click()
        success_message = driver.find_element(By.ID, "success").text
        self.assertEqual(success_message, "Registration successful!")

    def test_registration_with_existing_username(self):
        driver = self.driver
        driver.find_element(By.NAME, "username").send_keys("existinguser")
        driver.find_element(By.NAME, "email").send_keys("newuser@example.com")
        driver.find_element(By.NAME, "password").send_keys("password123")
        driver.find_element(By.NAME, "confirm_password").send_keys("password123")
        driver.find_element(By.NAME, "submit").click()
        error_message = driver.find_element(By.ID, "error").text
        self.assertEqual(error_message, "Username already exists!")

    def test_registration_with_invalid_email(self):
        driver = self.driver
        driver.find_element(By.NAME, "username").send_keys("newuser")
        driver.find_element(By.NAME, "email").send_keys("invalidemail")
        driver.find_element(By.NAME, "password").send_keys("password123")
        driver.find_element(By.NAME, "confirm_password").send_keys("password123")
        driver.find_element(By.NAME, "submit").click()
        error_message = driver.find_element(By.ID, "error").text
        self.assertEqual(error_message, "Invalid email address!")

if __name__ == "__main__":
    unittest.main()