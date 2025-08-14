Feature: Withdraw cash from account
  In order to pay for my daily expenses
  As an account holder
  I want to withdraw cash

  Scenario: Withdraw cash from account in credit
    Given I have a balance of <balance> in my account
    When I request <request>
    Then <dispensed> should be dispensed

  Example: Withdraw cash from account in credit
  | balance | request | dispensed | remaining |
  | 100     | 20      | 20        | 80       |
  | 100     | 50      | 50        | 50       |
