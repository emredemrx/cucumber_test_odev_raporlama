Feature: Checking the message received after clicking the button

  Scenario: Sayfa acilir
    Given Open the web site
    When Click on the button menu
    And Click on the clickMe
    Then message is checked 'You have done a dynamic click'

