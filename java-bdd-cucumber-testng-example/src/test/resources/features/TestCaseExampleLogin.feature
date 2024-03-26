Feature: Here is the tests to cover all test cases of Login and Logout features Scenarios

  @TC-01 @SmokeTest
  Scenario Outline: The Scenario to cover login Cases
    Given User have an account in System
    When User navigate to Login page
    And User login with "Login_Case" Credential via email and password
    Then User login "Login Expectation"

    Examples:
      | Cases                     | Login_Case                          | Login Expectation                       |
      | Case:1 Login successful   | Valid Credential                    | Login Successful                        |
      | Case:2 Login unsuccessful | Invalid Credential                  | Login Unsuccessful                      |
      | Case:3 Login blocked Case | Valid Credential and Blocked Status | Login Unsuccessful with Blocked message |

  @TC-02
  Scenario Outline: The Scenario to cover login Cases
    Given User have an account in System
    When User navigate to Login page
    And User login with "Login_Case" Credential via SSO
    Then User login "Login Expectation"

    Examples:
      | Cases                     | Login_Case                          | Login Expectation                       |
      | Case:1 Login successful   | Valid Credential                    | Login Successful                        |
      | Case:2 Login unsuccessful | Invalid Credential                  | Login Unsuccessful                      |
      | Case:3 Login blocked Case | Valid Credential and Blocked Status | Login Unsuccessful with Blocked message |