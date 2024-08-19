Feature: Adding and updating personnel to the table is controlled

  Scenario Outline: Adding and updating personnel to the table is controlled
    Given Open the web tables site
    When Click on the Add Button

    And The personnel information is filled in '<Firstname>' and '<Lastname>' and '<Mail>' and '<Age>' and '<Salary>' and '<Department>'
    Then click on the submit button

    When Click on the update button
    And The namespace is updated "veli"
    And The user saves the changes
    Then The user should see the updated record with "veli" in the table.

    Examples:
      | Firstname | Lastname | Mail       | Age | Salary | Department |
      | emre      | demir    | e@emre.com | 25  | 50000  | IT         |


