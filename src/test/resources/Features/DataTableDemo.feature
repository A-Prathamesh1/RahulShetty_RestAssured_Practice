Feature: User mgt using data table

  Scenario: create multiple users
    Given following users exists:
      | name       | email        | role                   |
      | Avyaan     | an@gmail.com | quantum algo developer |
      | Nityashree | nn@gmail.com | AI architect           |
      | Prathamesh | pa@gmail.com | Developer              |
    When sys processes users
    Then total users should be 3


  Scenario: verify list of browsers
    Given browser list contains:
      | chrome |
      | ff     |
      | opera  |