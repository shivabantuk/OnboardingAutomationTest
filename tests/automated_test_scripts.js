// Automated test scripts

const { test, expect } = require('@playwright/test');

test('example test', async ({ page }) => {
  await page.goto('https://example.com');
  const title = page.locator('h1');
  await expect(title).toHaveText('Example Domain');
});