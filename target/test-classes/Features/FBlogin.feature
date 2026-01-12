Feature: FB Login

  Scenario: valid login
    Given user is on the FB login page
    When I put username
    And I put pwd
    And click login button
    Then FB home page opens
    And correct username is dispalyed
    
    Scenario Outline: Invalid login
    Given user is on the FB login page
    When I put "<username>" and "<pwd>"
    And click login button
    Then Error appears
    
    Examples:
    |username|pwd|
    |abc|pqr|
    |xyz|xyz|
    