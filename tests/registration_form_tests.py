import unittest
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys

class RegistrationFormTests(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Chrome()
        self.driver.get('http://example.com/registration')

    def test_valid_registration(self):
        driver = self.driver
        driver.find_element(By.NAME, 'username').send_keys('testuser')
        driver.find_element(By.NAME, 'email').send_keys('testuser@example.com')
        driver.find_element(By.NAME, 'password').send_keys('Password123')
        driver.find_element(By.NAME, 'confirm_password').send_keys('Password123')
        driver.find_element(By.NAME, 'submit').click()
        self.assertIn('Registration successful', driver.page_source)

    def test_invalid_email(self):
        driver = self.driver
        driver.find_element(By.NAME, 'username').send_keys('testuser')
        driver.find_element(By.NAME, 'email').send_keys('invalid-email')
        driver.find_element(By.NAME, 'password').send_keys('Password123')
        driver.find_element(By.NAME, 'confirm_password').send_keys('Password123')
        driver.find_element(By.NAME, 'submit').click()
        self.assertIn('Invalid email address', driver.page_source)

    def tearDown(self):
        self.driver.quit()

if __name__ == '__main__':
    unittest.main()