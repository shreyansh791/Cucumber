Feature: ABC

  Scenario: VerifyHeaders
    Given user is on "HomePage"
    Then user verifies details in the table with "customers"
      | ScreenName | Value               |
      | Visit here | Alfreds Futterkiste |
      | Visit here | Maria Anders        |
      | Visit here | Germany             |
