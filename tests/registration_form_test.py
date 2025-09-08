# Automated test scripts for Registration Form
import unittest
from selenium import webdriver

class RegistrationFormTest(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Chrome()
        self.driver.get("http://example.com/registration")

    def test_registration_form(self):
        driver = self.driver
        driver.find_element_by_name("username").send_keys("testuser")
        driver.find_element_by_name("password").send_keys("password123")
        driver.find_element_by_name("email").send_keys("testuser@example.com")
        driver.find_element_by_name("submit").click()
        self.assertIn("Registration successful", driver.page_source)

    def tearDown(self):
        self.driver.quit()

if __name__ == "__main__":
    unittest.main()