# Automated test scripts for registration form

import unittest
from selenium import webdriver

class RegistrationFormTests(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Chrome()
        self.driver.get('http://example.com/registration')

    def test_validate_input_fields(self):
        driver = self.driver
        username_field = driver.find_element_by_name('username')
        email_field = driver.find_element_by_name('email')
        password_field = driver.find_element_by_name('password')
        self.assertTrue(username_field.is_displayed())
        self.assertTrue(email_field.is_displayed())
        self.assertTrue(password_field.is_displayed())

    def test_verify_form_submission(self):
        driver = self.driver
        username_field = driver.find_element_by_name('username')
        email_field = driver.find_element_by_name('email')
        password_field = driver.find_element_by_name('password')
        submit_button = driver.find_element_by_name('submit')
        username_field.send_keys('testuser')
        email_field.send_keys('testuser@example.com')
        password_field.send_keys('password123')
        submit_button.click()
        success_message = driver.find_element_by_id('success')
        self.assertTrue(success_message.is_displayed())

    def test_error_handling_and_messages(self):
        driver = self.driver
        submit_button = driver.find_element_by_name('submit')
        submit_button.click()
        error_message = driver.find_element_by_id('error')
        self.assertTrue(error_message.is_displayed())

    def tearDown(self):
        self.driver.quit()

if __name__ == '__main__':
    unittest.main()
