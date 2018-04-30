Feature: Being able to login
Scenario: Login
  Login with some username

    Given a list of users:
      | name    | password |
      | o1      | 123456   |
      | o2      | 123456   |
    When I login with name "o1" and password "123456"
    Then I receive the list of incidence of the user