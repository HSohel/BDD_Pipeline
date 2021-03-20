@MortgageCalculator
Feature: Mortgage Calculator

  @CalculateRate
  Scenario Outline:  Calculate Real Apr
    Given user is in the mortgage calculator home page
    And user navigates the real apr page
    When user clicks on calculate button upon entering "<HomePrice>", "<DownPayment>", "<InterestRate>", and "<Term>"
    Then validate that Real apr is "<AprRate>"
    Examples:
      | HomePrice | DownPayment | InterestRate | Term | AprRate |
      | 200000 | 15000 | 3 | 30 | 3.130% |


  @CalculateMonthlyPayment
  Scenario: Calculate Monthly Payment
    Given user is in the mortgage calculator home page
    When user enters required data and clicks on Calculate button
    Then validate Total Monthly Payment



