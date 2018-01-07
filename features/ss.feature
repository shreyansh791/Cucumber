Feature: ABC

  Scenario Outline: hh
    Given <user> is on Login Page
    And data is entered
      | ScreenName | LogicalName |
      | a          | e           |
      | b          | f           |
      | c          | g           |
      | d          | h           |

    Examples: 
      | user |
      | C    |
      | D    |
      #| E    |
      #| F    |
