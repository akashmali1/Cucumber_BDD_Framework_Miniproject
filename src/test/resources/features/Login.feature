Feature: Login functionality

  @smoke
  Scenario Outline: Successful login with valid credentials
    Given user is on the login page
    When  the user enters "<username>" and "<password>"
    Then the user should see "<outcome>"
    Examples:
      | username  | password      | outcome                  |
      | student   | Password123   | login successful message |
      | wrongUser | Password123   | username incorrect error |
      | student   | wrongPassword | password incorrect error |

