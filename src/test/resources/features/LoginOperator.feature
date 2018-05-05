Feature: Being able to login
Scenario: Login

    Given a list of users:
      | username    | password |
      | o1      | 123456   |
      | o2      | 123456   |
    When I login with name "o1" and password "123456"
    Then receives the list of incidence of the user