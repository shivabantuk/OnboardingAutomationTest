import unittest
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

class LoginTests(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Chrome()
        self.driver.get("https://example.com/login")

    def test_successful_login(self):
        username = self.driver.find_element(By.ID, "username")
        password = self.driver.find_element(By.ID, "password")
        submit = self.driver.find_element(By.ID, "submit")

        username.send_keys("validuser")
        password.send_keys("validpassword")
        submit.click()

        WebDriverWait(self.driver, 10).until(
            EC.presence_of_element_located((By.ID, "welcome-message"))
        )
        self.assertTrue(self.driver.find_element(By.ID, "welcome-message").is_displayed())

    def test_failed_login(self):
        username = self.driver.find_element(By.ID, "username")
        password = self.driver.find_element(By.ID, "password")
        submit = self.driver.find_element(By.ID, "submit")

        username.send_keys("invaliduser")
        password.send_keys("invalidpassword")
        submit.click()

        WebDriverWait(self.driver, 10).until(
            EC.presence_of_element_located((By.ID, "error-message"))
        )
        self.assertTrue(self.driver.find_element(By.ID, "error-message").is_displayed())

    def tearDown(self):
        self.driver.quit()

class PasswordResetTests(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Chrome()
        self.driver.get("https://example.com/password-reset")

    def test_password_reset_request(self):
        email = self.driver.find_element(By.ID, "email")
        submit = self.driver.find_element(By.ID, "submit-reset")

        email.send_keys("user@example.com")
        submit.click()

        WebDriverWait(self.driver, 10).until(
            EC.presence_of_element_located((By.ID, "confirmation-message"))
        )
        self.assertTrue(self.driver.find_element(By.ID, "confirmation-message").is_displayed())

    def tearDown(self):
        self.driver.quit()

if __name__ == "__main__":
    unittest.main()