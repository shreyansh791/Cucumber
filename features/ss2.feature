Feature: ABC

  Scenario Outline: Sample Scenario
    Given <user> is on "Home Page"
    #And user select item
    #  | ScreenName | LogicalName |
    #  | action     | child       |
    # And user loads page
    # And user enters data in textbox
    #  | ScreenName | LogicalName | Value     |
    # | action     | Email       | Shreyansh |
    # And user switch to childwindow
    # And user select item
    #   | ScreenName | LogicalName |
    #   | action     | yo          |
    # And user switch to parentwindow
    # And user loads page
    And user upload the document
      | ScreenName | LogicalName | Value    |
      | action     | upload      | HowtosolvestaleElementReferenceexceptioninSeleniumWebdriver.docx|

    #    When user captures the value
    #    | ScreenName | LogicalName | Value  |
    #    | action     | vhv       | $ghg|
    Examples: 
      | user |
      | a    |
      #| b    |
