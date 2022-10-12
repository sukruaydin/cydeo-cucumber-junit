Feature: User should be able to login using correct credentials


  Scenario:Positive login scenario
    Given User is on the login page of web table app
    When User enters "Test" in username input box
    And User enters "Tester" in password input box
    And User clicks to login button
    Then User should see url contains orders


  Scenario:Positive login scenario
    Given User is on the login page of web table app
    When User enters username "Test" password "Tester" and logins
    Then User should see url contains orders



  Scenario: User should be able to see all 12 months in
  months dropdown
    Given User is on the login page of web table app
    When User enters below credentials
      | username | Test   |
      | password | Tester |
    Then User should see url contains orders
