import unittest
from selenium import webdriver
from selenium.webdriver.common.by import By

class RegistrationFormTests(unittest.TestCase):

    def setUp(self):
        self.driver = webdriver.Chrome()
        self.driver.get('http://example.com/registration')

    def test_registration_form(self):
        driver = self.driver
        driver.find_element(By.NAME, 'username').send_keys('testuser')
        driver.find_element(By.NAME, 'password').send_keys('password123')
        driver.find_element(By.NAME, 'email').send_keys('testuser@example.com')
        driver.find_element(By.NAME, 'submit').click()

        success_message = driver.find_element(By.ID, 'success').text
        self.assertEqual(success_message, 'Registration successful!')

    def tearDown(self):
        self.driver.quit()

if __name__ == '__main__':
    unittest.main()
