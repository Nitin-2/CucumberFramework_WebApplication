
Feature: Login function for Magnushealth Application

  @LoginTest
  Scenario Outline: To verify Login function
    When magnushealth Application is Launch
    Then User enters valid UserName "<username>"
    Then User enters valid Password "<password>"
    Then User click on Login button
    Then User close the Browser

    Examples: 
      | username     | password   |
      | n.sharma-reseller | Magnushealth@123 |
