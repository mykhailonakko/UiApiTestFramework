Feature: Login

  Scenario Outline: Verify user is unable to login with invalid credentials
    Given I am on Login page
    When I enter username "<username>" and password "<password>"
    Then I check login is not successful
    Examples:
      | username      | password  |
      | not_existing  | 123456789 |
      | invalid_login | test1234  |
