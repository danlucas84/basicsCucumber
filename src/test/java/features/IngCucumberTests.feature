@IngTesting
Feature: Our First Ing Cucumber Tests

  Scenario Outline: User is shown correct Monthly Expenditure
    When User opens Ing Personal Account page
    Then Personal Monthly Expenditure equals <expectedSpending>

    Examples:
      | expectedSpending |
      | 1181.00          |


  Scenario Outline: User is shown correct Account Balance for account type <accountType>
    When User opens Ing Personal Account page
    Then <accountType> Balance equals <expectedBalance>

    @PersonalAccountTests
    Examples:
      | accountType | expectedBalance |
      | Personal    | 2025.00         |

    @SavingsTests
    Examples:
      | accountType | expectedBalance |
      | Savings     | 12804.62        |
    @CardTests
    Examples:
      | accountType | expectedBalance |
      | Card        | 1720.00         |

    Scenario: User is able to log out from ing demo site
      When User click logout button
      Then User is loged out (see new page)