Feature: Different Elements Page tests

  Scenario: Different Elements Page Interface test
    Given I am on "Home Page"
    Then The browser title is Home Page
    When I login as user epam with password 1234
    Then The user icon PITER CHAILOVSKII is displayed on the header
    Then Interface on Home Page contains all needed elements:
      | Benefit pictures | 4 |
      | Benefit texts    | 4 |
      | Header text      | 1 |
      | Subheader text   | 1 |
    When I click on "Service" button in Header
    Then Upper Service drop down opens with options:
      | Support            |
      | Dates              |
      | Complex Table      |
      | Simple Table       |
      | Table with pages   |
      | Different elements |
    When I click on the left Service subcategory
    Then Left Service drop down opens with options:
      | Support            |
      | Dates              |
      | Complex Table      |
      | Simple Table       |
      | Table with pages   |
      | Different elements |
    When I click on "Service" button in Header
    And I click on "Different Elements" button in Service dropdown
    Then "Different Elements" page is opened
    Then Interface on Different Elements Page contains all needed elements:
      | Checkboxes | 4 |
      | Radios     | 4 |
      | Dropdown   | 1 |
      | Buttons    | 2 |
    Then The right section of the page is displayed
    Then The left section of the page is displayed
    When I set following checkboxes to true:
      | Water |
      | Wind  |
    Then Setting of the following checkboxes to true will be properly logged:
      | Water |
      | Wind  |
    When I select Selen radio-button
    Then Selecting of Selen radio-button will be properly logged
    When I select Yellow item from the Colors Drop Down menu
    Then Selecting of Yellow drop down menu item will be properly logged
    When I set following checkboxes to false:
      | Water |
      | Wind  |
    Then Setting of the following checkboxes to false will be properly logged:
      | Water |
      | Wind  |

