Feature: DealX_SignIn

  Scenario: Sign in
    Given Navigate to URL
    When I click on Sign in button
    Then I enter invalid credentials "InvalidUsername" and "InvalidPassword"
    Then I click on login button
    Then I confirm login is unsuccessful
    Then I enter valid credentials "Username" and "Password"
    Then I click on login button
    And I confirm login is successful
