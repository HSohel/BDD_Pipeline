@LoginTest
Feature: Test Login Functionalities

  Background:
    Given User is on the login page

  @PositiveTest
  Scenario:  Check Login is successful wit valid credentials
    When  User enters Username "Sohel" and Password "12345"
    And Usr click on the login button
    Then  User should be landed to Home page

  @DataDrivenTest
  Scenario Outline:  Check Login is successful wit valid credentials for multiple users
    When  User enters Username "<username>" and Password "<password>"
    And Usr click on the login button
    Then  User should be landed to Home page
    Examples:
      | username | password |
      | Sohel | 12345 |
      | Zinnah | 12345 |
      | Rouf | 12345 |

  @NegativeTest
  Scenario Outline:  Check Login is not successful with invalid credentials
    When  User enters Username "<username>" and Password "<password>"
    And Usr click on the login button
    Then  User should not be landed to Home page
    Examples:
      | username | password |
      | Adam | 4444 |
      | Peter | 4444 |



