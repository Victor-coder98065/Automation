Feature: Cart

  Background: 
    Given Navigate to URL
    When I click on Sign in button
    Then I enter invalid credentials "InvalidUsername" and "InvalidPassword"
    Then I click on login button
    Then I confirm login is unsuccessful
    Then I enter valid credentials "Username" and "Password"
    Then I click on login button
    And I confirm login is successful
    
    Scenario: Add item to cart
    When I click on Tshirt button
    Then I hover over Tshirt image and click
    And I click on view cart
    Then I increase quantity
    Then Calculate total
