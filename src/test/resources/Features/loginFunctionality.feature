Feature: Login Feature
  login feature allows user with valid credentials to get access of application

  @skip
  Background:
    Given User must be on login page

  Scenario: User with valid credentials should be able to login
    Given User enters valid username "uname"
    And User enters valid password "pass"
    When user clicks on login button
    Then user should should see the dashboard
    And user should see the "welcome" message

  Scenario: When user enters invalid credentials should not be able to login
    Given when user enters invalid username "invalidUname"
    And when user enters invalid password "invalidPass"
    When user click login button
    Then user should not be logged in
    And user should see "invalid credentials" error message

  Scenario Outline: When multiple users login
    Given when user enter "<uname>"
    And when user enter "<password>"
    When user clicks on login button
    Then user user should see "<message>"

    Examples:
      | uname  | password | message      |
      | uname1 | pass1    | welcome      |
      | uname2 | pass2    | invalid cred |
      | uname3 |          | error        |