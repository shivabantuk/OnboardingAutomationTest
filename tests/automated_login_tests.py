import unittest
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

class AutomatedLoginTests(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Chrome()
        self.driver.get("https://example.com/login")  # Replace with actual login page URL

    def tearDown(self):
        self.driver.quit()

    def test_successful_login(self):
        username = self.driver.find_element(By.ID, "username")
        password = self.driver.find_element(By.ID, "password")
        submit = self.driver.find_element(By.ID, "submit")

        username.send_keys("testuser")
        password.send_keys("testpassword")
        submit.click()

        # Wait for the dashboard page to load
        WebDriverWait(self.driver, 10).until(
            EC.presence_of_element_located((By.ID, "dashboard"))
        )

        self.assertIn("Dashboard", self.driver.title)

    def test_failed_login(self):
        username = self.driver.find_element(By.ID, "username")
        password = self.driver.find_element(By.ID, "password")
        submit = self.driver.find_element(By.ID, "submit")

        username.send_keys("wronguser")
        password.send_keys("wrongpassword")
        submit.click()

        # Wait for the error message to appear
        error_message = WebDriverWait(self.driver, 10).until(
            EC.presence_of_element_located((By.CLASS_NAME, "error-message"))
        )

        self.assertIn("Invalid username or password", error_message.text)

    def test_password_reset(self):
        reset_link = self.driver.find_element(By.LINK_TEXT, "Forgot Password?")
        reset_link.click()

        # Wait for the password reset page to load
        WebDriverWait(self.driver, 10).until(
            EC.presence_of_element_located((By.ID, "reset-form"))
        )

        email = self.driver.find_element(By.ID, "email")
        submit = self.driver.find_element(By.ID, "reset-submit")

        email.send_keys("testuser@example.com")
        submit.click()

        # Wait for the confirmation message
        confirmation = WebDriverWait(self.driver, 10).until(
            EC.presence_of_element_located((By.CLASS_NAME, "confirmation-message"))
        )

        self.assertIn("Password reset email sent", confirmation.text)

if __name__ == "__main__":
    unittest.main()