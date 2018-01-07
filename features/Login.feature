Feature: Guru99 Application Testing

  Scenario Outline: Login Scenario
    Given "<user>" is on "Home Page1"
    When user selects item
      | ScreenName | LogicalName |
      | Gmail      | gmail       |
    And user loads page
      """
      Hello Mr. Jain
      """

    Examples:
      | user |
      | a    |
